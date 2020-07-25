package Model.Usuario;

/**
 *
 * @author sam
 */
/**
 * Esta clase se encarga de recibir los datos relacionados con los usuarios del
 * sistema. Sirve como capa intermedia para pasar los datos obtenidos en los
 * distintos campos de texto de la interfaz gráfica de usuario. Tiene sus
 * correspondientes métodos getters y settes para este propósito
 */
public class Usuario {

    private int userId;
    private String username;
    private String email;
    private String password;
    public static String password1;

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
