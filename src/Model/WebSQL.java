package Model;

import Extras.Conexion;
import GUI.Inicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
public class WebSQL {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void actualizarDatos(Inicio init ) {
        con = Conexion.getConnection();
        String sql="UPDATE Website SET web_name=?,web_username=?,web_email=?,web_pass=? WHERE web_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, init.txt_fname.getText());
            ps.setString(2, init.txt_fusername.getText());
            ps.setString(3, init.txt_femail.getText());
            ps.setString(4, new String(init.txt_fpass.getPassword()));
            ps.setInt(5, Integer.parseInt(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 1).toString().trim()));
            System.out.println(new String(init.txt_pass.getPassword())); 
            int res=ps.executeUpdate();
            if (res>0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

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
           ps = con.prepareStatement("INSERT INTO Website(user_id,web_name,web_username,web_email,web_pass,notas) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(init.lbl_user_id.getText()));
            ps.setString(2, init.txt_url.getText());
            ps.setString(3, init.txt_username.getText());
            ps.setString(4, init.txt_email.getText());
           ps.setString(5, new String(init.txt_pass.getPassword()));
           ps.setString(6, init.txa_rnota.getText());
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

}
