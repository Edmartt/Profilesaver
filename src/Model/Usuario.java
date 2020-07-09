package Model;

import GUI.Inicio;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author sam
 */
public class Usuario {

    private int userId;
    private String username;
    private String email;
    private String password;
    public static String password1;
    //----------------------------
    private PreparedStatement ps = null;
    private Connection con = null;
    private Inicio init;

   
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void loguearse(Login log, SQL sql) {
//
//        this.setUsername(log.txt_name.getText());
//        this.setPassword(SHA256.getSHA256(log.txt_pass.getText()));
//        sql.iniciarSesion(this, this.init);
//
//    }
//
//    public void crearUsuarioEvent(Registro reg, SQL sql) {
//        this.setUsername(reg.txt_nreg.getText());
//        this.setEmail(reg.txt_email.getText());
//        char[] pass1 = reg.txt_passreg.getPassword();
//        String password2 = new String(pass1);
//        this.setPassword(SHA256.getSHA256(password2));
//        char[] pass2 = reg.txt_passconf.getPassword();
//        String password3 = new String(pass2);
//        if (this.getPassword().equals(SHA256.getSHA256(password3))) {
//            sql.crearUsuario(this, reg);
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
//
//        }
//
//    }

//    public void hidePanel(Inicio init) {
//        init.lbl_slide.setLocation(20, 10);
//        init.pan_slide.setSize(50, 600);
//
//    }
//
//    public void showPanel(Inicio init) {
//        init.lbl_slide.setLocation(270, 0);
//        init.pan_slide.setSize(300, 600);
//
//    }

}
