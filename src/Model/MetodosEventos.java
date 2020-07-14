package Model;

import Model.websites.WebSQL;
import Model.websites.WebSite;
import Model.Usuario.UserSQL;
import Model.Usuario.Usuario;
import Extras.SHA256;
import GUI.Inicio;
import GUI.Login;
import GUI.Registro;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */

/**
 * La clase método eventos contiene métodos que llaman a otros métodos
 * tales como los métodos de la clase WebSQL, con el propósito de no cargar
 * de código la clase controlador y hacerla más legible.
 * Algo más que tiene como objetivo esta clase, es asignar los datos obtenidos
 * en los distintos campos de texto de la interfaz gráfica a los métodos setters y getters
 * de las clases Website y Usuario
 * 
 */
public class MetodosEventos {

    public void loguearse(Login log, UserSQL sql, Usuario user, Inicio init) {
        user.setUsername(log.txt_name.getText());
        user.setPassword(SHA256.getSHA256(log.txt_pass.getText()));
        sql.iniciarSesion(user, init, log);
    }

    public void registrarUser(Registro reg, UserSQL sql, Usuario user) {
        user.setUsername(reg.txt_nreg.getText());
        user.setEmail(reg.txt_email.getText());
        char[] pass1 = reg.txt_passreg.getPassword();
        String password2 = new String(pass1);
        user.setPassword(SHA256.getSHA256(password2));
        char[] pass2 = reg.txt_passconf.getPassword();
        String password3 = new String(pass2);
        if (user.getPassword().equals(SHA256.getSHA256(password3))) {
            sql.crearUsuario(user, reg);
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
    }

    public void registrarWeb(Inicio init, WebSite web, WebSQL websql) {
        web.setWeb_name(init.txt_url.getText());
        web.setWeb_username(init.txt_username.getText());
        web.setWeb_email(init.txt_email.getText());
        web.setWeb_pass(new String(init.txt_pass.getPassword()));
        web.setNota(init.txa_rnota.getText());
        if (new String(init.txt_pass.getPassword()).equals(new String(init.txt_pass1.getPassword()))) {
            websql.agregarWeb(web);
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
    }

    public void updateWebs(Inicio init, WebSQL websql, WebSite web) {
        web.setWeb_name(init.txt_fname.getText());
        web.setWeb_username(init.txt_fusername.getText());
        web.setWeb_email(init.txt_femail.getText());
        web.setWeb_pass(new String(init.txt_fpass.getPassword()));
        web.setNota(init.txa_nota.getText());
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos?", "Actualizar", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            websql.actualizarWeb(web, init);
        }
    }

    public void deleteWeb(WebSQL websql, Inicio init) {
        int res = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este perfil?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (res == 0) {
            websql.eliminarWeb(init);
        }
    }

    public void hidePanel(Inicio init) {
        init.lbl_slide.setLocation(10, 10);
        init.pan_slide.setSize(50, 550);
        hideButtons(init);
    }

    public void showPanel(Inicio init) {
        init.lbl_slide.setLocation(170, 10);
        init.pan_slide.setSize(200, 550);
        showButtons(init);
    }

    private void hideButtons(Inicio init) {
        init.btn_add.setLocation(-10, -190);
        init.btn_ver.setLocation(-10, -260);
        init.jButton4.setLocation(-10, -330);
        init.btn_set.setLocation(-10, -400);
    }

    private void showButtons(Inicio init) {
        init.btn_add.setLocation(0, 190);
        init.btn_ver.setLocation(0, 260);
        init.jButton4.setLocation(0, 330);
        init.btn_set.setLocation(0, 400);
    }

    public void mostrarDatos(Inicio init) {
        init.txt_fname.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 2).toString().trim());
        init.txt_fusername.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 3).toString().trim());
        init.txt_femail.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 4).toString().trim());
        init.txt_fpass.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 5).toString().trim());
        init.txa_nota.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 6).toString().trim());
    }

}
