package Model.Usuario;

import GUI.Inicio;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import Extras.Conexion;
import Extras.SHA256;
import GUI.Login;
import GUI.Registro;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
/**
 * Esta clase contiene todos los métodos relacionados con consultas SQL sobre
 * datos del usuario del sistema
 */
public class UserSQL {
/**
 * Almacenaremos el resultado de la conexión a la BD
 */
    Connection con = null;
    /**
     * Almacenamos objeto donde estará nuestra consulta SQL
     */
    PreparedStatement ps = null;
    /**
     * Los resultados arrojados de nuestra consulta estarán en un objeto booleano
     */
    ResultSet rs = null;

/**
 * Comprueba la existencia del usuario en la BD.debe retornar en caso de existir, el conteo total de usuarios con
 dicho nombre de usuario.Si no hay resultados devolverá el entero 1
 Se entiende que devolverá el resultado con 0 coincidencias si el usuario no existe
 y si existe devuelve el número de usuarios existentes
     * @param user el parámetro indica que debe recibir una instancia de la clase usuario
     * @return 
 */
    public int existeUsuario(Usuario user) {
        con = Conexion.getConnection();

        String sql = "SELECT COUNT(user_id) FROM Usuario WHERE username=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 1;
    }
/**
 * Este método lo que hace es devolvernos ciertos datos del usuario
 * con el que iniciamos sesión y dichos datos los usamos para mostrarlos
 * en el panel de ajustes y poder saber lo que estamos modificando en caso 
 * de querer hacerlo
     * @return retorna un arraylist con los datos
 */
    public ArrayList getDatos() {
        con = Conexion.getConnection();
        ArrayList<String> datos = new ArrayList<>(10);
        String sql = "SELECT * FROM Usuario WHERE user_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Inicio.lbl_user_id.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                datos.add(rs.getString("username"));
                datos.add(rs.getString("email"));
                datos.add(rs.getString("password"));
                return datos;
            }
        } catch (SQLException e) {
        }
        return datos;
    }
/**
 * 
 */
    public void modUsername(Usuario user) {
        con = Conexion.getConnection();
        try {
            ps = con.prepareStatement("UPDATE Usuario SET username=? WHERE user_id=?");
            ps.setString(1, user.getUsername());
            ps.setInt(2, user.getUserId());
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario actualizado");
            } else {
                System.out.println("Ha ocurrido un error al actualizar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void eliminarUser(int userId) {
    }

    public void modEmail(Usuario user) {
        con = Conexion.getConnection();
        try {
            ps = con.prepareStatement("UPDATE Usuario SET email=? WHERE user_id=?");
            ps.setString(1, user.getEmail());
            ps.setInt(2, user.getUserId());
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Email actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void crearUsuario(Usuario user, Registro reg) {
        con = Conexion.getConnection();
        try {
            ps = con.prepareStatement("INSERT INTO Usuario (username,email,password) VALUES(?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                limpiar(reg);
            } else {
                System.out.println("Ha ocurrido un error");
            }
        } catch (MySQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "El email debe tener un formato válido");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Realiza una consulta a la base de datos, enviando los argumentos de la
     * clase usuario. Tanto el nombre de usuario como la contraseña que ha sido
     * previamente cifrada con el método estático getSHA256 en la clase
     * MetodosEventos.
     *
     * Si los hashes coinciden se usa el método setUserId de la clase usuario
     * para asignar el id de de usuario de la base de datos al atributo id de la
     * clase Usuario
     *
     * @param user
     * @param init
     * @param log
     */
    public void iniciarSesion(Usuario user, Inicio init, Login log) {

        con = Conexion.getConnection();
        try {
            ps = con.prepareStatement("SELECT * FROM Usuario WHERE username=? AND password=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();

            if (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                JOptionPane.showMessageDialog(null, "Sesi\u00f3n Iniciada");
                limpiar(log);
                log.dispose();
                init.setVisible(true);
                Inicio.lbl_user_id.setVisible(false);
            } else if(rs.next()==false){
                log.message.setText("El usuario o la contraseña podrían estar errados");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Modifica la contraseña de usuario de sistema en la opción ajustes de la
     * ventana principal. Se envía la cadena cifrada con un algoritmo SHA256,
     * del cual se hace llamado a un método estático que hace dicha tarea. Al
     * iniciar sesión no se comparan contraseñas, se comparan los hashes
     * guardados en la base de datos con los ingresados por el usuario en el
     * campo de password correspondiente
     *
     * @param user
     */
    public void modPassword(Usuario user) {
        con = Conexion.getConnection();
        try {
            ps = con.prepareStatement("UPDATE Usuario SET password=? WHERE user_id=?");
            ps.setString(1, SHA256.getSHA256(user.getPassword()));
            ps.setInt(2, user.getUserId());
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Password modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al realizar la modificación");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * limpiar deja las cajas de texto de las ventanas Inicio Registro y Login
     * en blanco.Según el objeto que se pase como argumento de estas tres
     * ventanas/clases se evalúa la condición y se hace el respectivo casting a
     * la clase correspondiente
     *
     * @param obj
     */
    public static void limpiar(Object obj) {
        if (obj instanceof Login) {
            Login log = (Login) obj;
            log.txt_name.setText(null);
            log.txt_pass.setText(null);
        } 
        
        else if (obj instanceof Registro) {
            Registro reg = (Registro) obj;
            reg.txt_email.setText(null);
            reg.txt_nreg.setText(null);
            reg.txt_passreg.setText(null);
            reg.txt_passconf.setText(null);
            reg.lbl_alert.setText(null);
            reg.lbl_okay.setVisible(false);
        } 
        
        else if (obj instanceof Inicio) {
            Inicio init = (Inicio) obj;
            init.txt_url.setText(null);
            init.txt_username.setText(null);
            init.txa_rnota.setText(null);
            init.txt_email.setText(null);
            init.txt_pass.setText(null);
            init.txt_pass1.setText(null);
            init.lbl_alert.setText(null);
            init.lbl_iconokay.setVisible(false);
            init.pan_ajustes.setVisible(false);
            init.pan_tab.setVisible(false);
        }
    }
}
