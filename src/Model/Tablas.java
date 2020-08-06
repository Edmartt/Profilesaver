/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Extras.Conexion;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 *
 * @author sam
 */
public class Tablas {

    PreparedStatement ps = null, ps2 = null;
    Connection con = null;

    String sql = "CREATE TABLE IF NOT EXISTS `Usuario`( \n"
            + "  `user_id` INTEGER PRIMARY KEY AUTOINCREMENT, \n"
            + "  `username` varchar(30) NOT NULL UNIQUE,\n"
            + "  `email` varchar(50),\n"
            + "  `password` varchar(80) NOT NULL,\n"
            + "  CONSTRAINT `CHK_email` CHECK (`email` like '%_@_%.___%'));";

    String sql2 = "CREATE TABLE IF NOT EXISTS `Website` (\n"
            + "`web_id` INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "\n  `user_id` INTEGER(10) NOT NULL ,"
            + "\n  `web_name` varchar(50) NOT NULL,"
            + "\n  `web_username` varchar(50) NOT NULL,"
            + "\n  `web_email` varchar(50) NOT NULL,"
            + "\n `web_pass` varchar(80) NOT NULL,"
            + "\n  `nota` varchar(255) DEFAULT NULL,"
            + "\n  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `Usuario` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,\n"
            + "\n  CONSTRAINT `CONSTRAINT_1` CHECK (`web_email` like '%_@_%.___%'));";

    public void crearTable() {

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            int res = ps.executeUpdate();

            ps = con.prepareStatement(sql2);
            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
