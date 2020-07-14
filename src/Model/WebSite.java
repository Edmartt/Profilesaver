package Model;

import GUI.Inicio;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.ResultSet;

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
    private String rnota;

    public WebSite() {

    }
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
    
    public String getNota(){
        return rnota;
    }
    
    public void setNota(String nota){
        this.rnota=nota;
    }

    public void mostrarDatos(Inicio init) {
        init.txt_fname.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 2).toString().trim());
        init.txt_fusername.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 3).toString().trim());
        init.txt_femail.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 4).toString().trim());
        init.txt_fpass.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 5).toString().trim());
        init.txa_nota.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 6).toString().trim());
        

    }

}
