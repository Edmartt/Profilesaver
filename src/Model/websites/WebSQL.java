package Model.websites;

import Extras.Conexion;
import GUI.Inicio;
import Model.Usuario.UserSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
/**
 * En esta clase se encuentran todos los métodos relacionados con consultas SQL
 * de la clase Website. Los métodos que se pueden encontrar son agregarWeb,
 * actualizarWeb y eliminarWeb
 */
public class WebSQL {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void actualizarWeb(WebSite web, Inicio init) {
        con = Conexion.getConnection();
        String sql = "UPDATE Website SET web_name=?,web_username=?,web_email=?,web_pass=?,nota=? WHERE web_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, web.getWeb_name());
            ps.setString(2, web.getWeb_username());
            ps.setString(3, web.getWeb_email());
            ps.setString(4, web.getWeb_pass());
            ps.setString(5, web.getNota());
            ps.setInt(6, Integer.parseInt(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 0).toString().trim()));
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                limpiarWeb(init);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }
    }

    /**
     * Método que se encarga de establecer conexión con la BD con el fin de
     * ingresar datos de los sitios web que se quieran guardar de forma
     * persistente
     *
     * @param web
     * @param init
     */
    public void agregarWeb(WebSite web,Inicio init) {
        con = Conexion.getConnection();
        try {
            ps = con.prepareStatement("INSERT INTO Website(user_id,web_name,web_username,web_email,web_pass,nota) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(Inicio.lbl_user_id.getText()));
            ps.setString(2, web.getWeb_name());
            ps.setString(3, web.getWeb_username());
            ps.setString(4, web.getWeb_email());
            ps.setString(5, web.getWeb_pass());
            ps.setString(6, web.getNota());
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Perfil agregado");
                UserSQL.limpiar(init);
            } else {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "El correo debe contener un formato válido");
        }
    }

    public void eliminarWeb(Inicio init) {
        con = Conexion.getConnection();
        String sql = "DELETE FROM Website WHERE web_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 0).toString()));
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Sitio Web Eliminado");
                limpiarWeb(init);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado nada");
        }
    }
    
    private void limpiarWeb(Inicio init){
        init.txt_fname.setText(null);
        init.txt_femail.setText(null);
        init.txt_fpass.setText(null);
        init.txt_fusername.setText(null);
        init.txa_nota.setText(null);
    }
}
