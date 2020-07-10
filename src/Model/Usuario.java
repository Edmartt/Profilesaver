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

}
