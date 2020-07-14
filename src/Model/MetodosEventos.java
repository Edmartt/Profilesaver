package Model;

import Extras.SHA256;
import GUI.Inicio;
import GUI.Login;
import GUI.Registro;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
public class MetodosEventos {

    public void loguearse(Login log, SQL sql, Usuario user, Inicio init) {
        user.setUsername(log.txt_name.getText());
        user.setPassword(SHA256.getSHA256(log.txt_pass.getText()));
        sql.iniciarSesion(user, init, log);
    }

    public void registrarUser(Registro reg, SQL sql, Usuario user) {
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
        }       
        else {
            JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
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
