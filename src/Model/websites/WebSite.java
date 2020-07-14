package Model.websites;

import Model.Usuario.Usuario;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.ResultSet;

/**
 *
 * @author sam
 */
/**
 * Esta clase se encarga de recibir los datos relacionados con los perfiles de los
 * sitios que el usuario desea guardar en la base de datos. 
 * Sirve como capa intermedia para pasar los datos obtenidos en los
 * distintos campos de texto de la interfaz gráfica de usuario. Tiene sus
 * correspondientes métodos getters y settes para este propósito
 */
public class WebSite {

    Usuario user;
    Scanner in = new Scanner(System.in);
    private int web_id;
    private String web_name;
    private String web_username;
    private String web_email;
    private String web_pass;
    private String rnota;
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;

    public int getWeb_id() {
        return web_id;
    }

    public void setWeb_id(int web_id) {
        this.web_id = web_id;
    }

    public String getWeb_name() {
        return web_name;
    }

    public void setWeb_name(String web_name) {
        this.web_name = web_name;
    }

    public String getWeb_username() {
        return web_username;
    }

    public void setWeb_username(String web_username) {
        this.web_username = web_username;
    }

    public String getWeb_email() {
        return web_email;
    }

    public void setWeb_email(String web_email) {
        this.web_email = web_email;
    }

    public String getWeb_pass() {
        return web_pass;
    }

    public void setWeb_pass(String web_pass) {
        this.web_pass = web_pass;
    }

    public String getNota() {
        return rnota;
    }

    public void setNota(String nota) {
        this.rnota = nota;
    }
}
