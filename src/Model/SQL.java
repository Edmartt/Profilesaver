package Model;

import GUI.Inicio;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import Extras.Conexion;
import Extras.SHA256;
import GUI.Login;
import GUI.Registro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 *
 * @author sam
 */
public class SQL {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void modUsername(String username, int userId, Usuario usuario) {
        con = Conexion.getConnection();
        try {

            ps = con.prepareStatement("UPDATE Usuario SET username=? WHERE user_id=?");
            ps.setString(1, username);
            ps.setInt(2, userId);
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("");
                System.out.println("Nombre de usuario actualizado correctamente");
            } else {
                System.out.println("Ha ocurrido un error al actualizar.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void eliminarUser(int userId) {
    }

    public void modEmail(int userId, String email, Usuario usuario) {
        con = Conexion.getConnection();
        try {

            ps = con.prepareStatement("UPDATE Usuario SET email=? WHERE user_id=?");
            ps.setString(1, email);
            ps.setInt(2, userId);
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("");
                System.out.println("Correo actualizado correctamente");
            } else {
                System.out.println("Ha ocurrido un error al actualizar");
            }
        } catch (SQLException e) {
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
            con.close();
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Est\u00e1 ingresando un dato ya existente. Puede ser el email o el nombre de usuario");
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
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
                init.lbl_user_id.setVisible(false);

            } else {
                System.out.println("El usuario o contrase\u00f1a podr\u00edan estar errados.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void modPassword(int userId, String password, Usuario usuario) {
        con = Conexion.getConnection();
        try {
            ps = con.prepareStatement("UPDATE Usuario SET password=? WHERE user_id=?");
            ps.setString(1, SHA256.getSHA256(password));
            ps.setInt(2, userId);
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("Contrase\u00f1a actualizada correctamente");
            } else {
                System.out.println("Error al actualizar");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void limpiar(Login log) {
        log.txt_name.setText(null);
        log.txt_pass.setText(null);

    }
}
