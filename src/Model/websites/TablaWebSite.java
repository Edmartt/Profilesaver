/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.websites;

import javax.swing.JTable;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import Extras.Conexion;
import GUI.Inicio;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import javax.swing.BorderFactory;

/**
 *
 * @author sam
 */
/**
 * En esta clase se moldea la tabla que mostrará los datos de los perfiles de sitios
 * guardados por el usuario. Tiene métodos como mostrarWebs que se encargan de mostrar
 * los datos en la tabla y ajustar tabla, entre otros, que dan estilo a la tabla.
 */
public class TablaWebSite {

    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;

    public void mostrarWebs(Inicio init) {
        DefaultTableModel model = new DefaultTableModel();
        init.tb_mostrar.setModel(model);

        model.addColumn("web_id");
        model.addColumn("user_id");
        model.addColumn("Nombre");
        model.addColumn("Nombre de usuario");
        model.addColumn("Email");
        model.addColumn("Password");
        model.addColumn("Notas");

        init.tb_mostrar.getColumnModel().getColumn(0).setMaxWidth(0);
        init.tb_mostrar.getColumnModel().getColumn(0).setMinWidth(0);
        init.tb_mostrar.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        init.tb_mostrar.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        init.tb_mostrar.getColumnModel().getColumn(1).setMaxWidth(0);
        init.tb_mostrar.getColumnModel().getColumn(1).setMinWidth(0);
        init.tb_mostrar.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        init.tb_mostrar.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        init.tb_mostrar.getColumnModel().getColumn(6).setMaxWidth(0);
        init.tb_mostrar.getColumnModel().getColumn(6).setMinWidth(0);
        init.tb_mostrar.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        init.tb_mostrar.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
             init.tb_mostrar.getColumnModel().getColumn(5).setMaxWidth(0);
        init.tb_mostrar.getColumnModel().getColumn(5).setMinWidth(0);
        init.tb_mostrar.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        init.tb_mostrar.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        init.tb_mostrar.getColumnModel().getColumn(5).setCellRenderer(new PasswordCellRenderer());
        ajustarCabecera(init.tb_mostrar);

        con = Conexion.getConnection();
        String sql = "SELECT web_id,user_id,web_name,web_username,web_email,web_pass,nota FROM Website WHERE user_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(Inicio.lbl_user_id.getText()));
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            Object[] array = new Object[col];

            while (rs.next()) {
                for (int i = 0; i < col; i++) {
                    array[i] = rs.getObject(i + 1);
                }
                model.addRow(array);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    private void ajustarCabecera(JTable tabla) {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setForeground(Color.WHITE);
        headerRenderer.setBackground(new Color(17, 138, 178));
        /*Fin de modificación*/
        for (int i = 0; i < tabla.getModel().getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    public static void ajustarTabla(Inicio init) {
        init.tb_mostrar.setIntercellSpacing(new Dimension(0,0));
        init.scroll.getViewport().setBackground(Color.WHITE); //Fondo del contenedor de la tabla
        init.tb_mostrar.getTableHeader().setFont(new Font("Liberation Sans", Font.BOLD, 13));
        init.tb_mostrar.getTableHeader().setOpaque(true);
        init.tb_mostrar.setRowHeight(25);
        init.tb_mostrar.setDefaultEditor(Object.class, null); //Evita la edición de la tabla
        init.scroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); //Quita los bordes visibles de la tabla y de su contenedor
    }

    class PasswordCellRenderer extends DefaultTableCellRenderer {
        private static final String ASTERISCOS = "********************";
        
        @Override
        public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
            int lenght = 0;
            if (arg1 instanceof String) {
                lenght = ((String) arg1).length();
            } else if (arg1 instanceof char[]) {
                lenght = ((char[]) arg1).length;
            }
            setText(asteriscos(lenght));
            return this;
        }
    }

    private String asteriscos(int lenght) {
        if (lenght > PasswordCellRenderer.ASTERISCOS.length()) {
            StringBuilder sb = new StringBuilder(lenght);
            for (int i = 0; i < lenght; i++) {
                sb.append('*');
            }
            return sb.toString();
        } else {
            return PasswordCellRenderer.ASTERISCOS.substring(0, lenght);
        }
    }
}
