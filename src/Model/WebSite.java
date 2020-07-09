package Model;

import Model.Usuario;
import Extras.Conexion;
import Extras.SHA256;
import GUI.Inicio;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
public class WebSite {

    Usuario user;
    Scanner in = new Scanner(System.in);
    private int web_id;
    private String web_name;
    private String web_username;
    private String web_email;
    private String web_pass;
    public int cantidad = 0;

    public WebSite() {

    }

    public static int[] vector;
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

    /**
     * Método que se encarga de establecer conexión con la BD con el fin de
     * ingresar datos de los sitios web que se quieran guardar de forma
     * persistente
     *
     * @param init
     */
    public void agregarWeb(Inicio init) {
        con = Conexion.getConnection();

        try {
            
            ps = con.prepareStatement("INSERT INTO Website(user_id,web_name,web_username,web_email,web_pass) VALUES(?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(init.lbl_user_id.getText()));
            ps.setString(2, init.txt_url.getText());
            ps.setString(3, init.txt_username.getText());
            ps.setString(4, init.txt_email.getText());
            ps.setString(5, new String(init.txt_pass.getPassword()));
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Perfil agregado");

            } else {
                System.out.println("Ha ocurrido un error");

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void consultarWebs() {

        con = Conexion.getConnection();
       
        

    }

    public int contar() {
        con = Conexion.getConnection();
        int count = 0;
        String sql = "SELECT COUNT(web_id) FROM Website WHERE user_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;

            }

        } catch (SQLException e) {
        }
        return count;
    }

    public void eliminarWeb() {
        con = Conexion.getConnection();
        String sql = "DELETE FROM Website WHERE web_id=?";
        System.out.println("Elija un sitio a eliminar: ");
        int sel = in.nextInt();
        try {
            for (int i = 0; i < vector.length; i++) {
                if (sel == vector[i]) {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, sql);
                    int res = ps.executeUpdate();
                    if (res > 0) {
                        System.out.println("Se ha eliminado el sitio");
                        i = vector.length + 1;
                    }

                }
            }

        } catch (SQLException e) {

        }

    }
}
