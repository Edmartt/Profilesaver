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

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public static String un;

    public static boolean comprobar(String password, int used_id) {
        com.mysql.jdbc.Connection con = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM Usuario WHERE user_id=?";
        boolean band = false;
        Conexion.getConnection();
        try {
            ps = Conexion.getConnection().prepareStatement(sql);
            ps.setInt(1, used_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(Usuario.password1)) {
                    band = true;
                    return band;
                }
            } else {
                band = false;
                return band;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return band;
    }

   
    public ArrayList getDatos() {
        con = Conexion.getConnection();
        ArrayList <String> datos = new ArrayList<>(10);
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
            } else {
                System.out.println("Ha ocurrido un error");
            }
            
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Est\u00e1 ingresando un dato ya existente. Puede ser el email o el nombre de usuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

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
            } else {
                JOptionPane.showMessageDialog(null,"El usuario o la contraseña podrían estar errados");
                limpiar(log);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

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

    private void limpiar(Login log) {
        log.txt_name.setText(null);
        log.txt_pass.setText(null);
    }
}
