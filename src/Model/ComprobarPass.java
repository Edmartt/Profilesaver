/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import Extras.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author sam
 */
public class ComprobarPass {

    public static boolean comprobar(String password, int used_id) {
        Connection con = null;
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

}
