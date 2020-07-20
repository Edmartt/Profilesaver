package controller;

import GUI.Inicio;
import java.awt.event.ActionListener;
import GUI.Login;
import GUI.ModEmail;
import GUI.ModPassword;
import GUI.ModUsername;
import GUI.Registro;
import Model.MetodosEventos;
import Model.Usuario.UserSQL;
import Model.websites.TablaWebSite;
import Model.Usuario.Usuario;
import Model.websites.WebSQL;
import Model.websites.WebSite;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import style.StyleInicio;

/**
 *
 * @author sam
 */
/**
 * Esta clase es la encargada de gestionar las acciones llevadas a cabo por el
 * usuario del sitema, tales como clicks de botones, movimientos de mouse, que
 * deberían dar una respuesta concreta a la acción, lo que desata eventos.
 */
public class Controller implements ActionListener, MouseListener {

    private Login log;
    private Inicio init;
    private Usuario user;
    private Registro reg;
    private UserSQL sql;
    private MetodosEventos event;
    private WebSQL websql;//métodos para UserSQL Website
    private WebSite web;
    private TablaWebSite tb;
    private StyleInicio stylein;
    private ModUsername mod;
    private ModEmail modEm;
    private ModPassword modpass;

    public Controller() {
        reg = new Registro();
        event = new MetodosEventos();
        sql = new UserSQL();
        log = new Login();
        init = new Inicio();
        stylein = new StyleInicio();
        websql = new WebSQL();
        web = new WebSite();
        mod = new ModUsername();
        modEm = new ModEmail();
        modpass = new ModPassword();
        stylein.setImage(init);
        init.pan_tab.setVisible(false);
        tb = new TablaWebSite();
        init.pan_form.setVisible(false);
        init.pan_slide.setBorder(new SoftBevelBorder(0, null, null, null, Color.black));
        user = new Usuario();
        log.setVisible(true);

        buttons();

    }

    private void buttons() {
        log.btn_log.addActionListener(this);
        log.lbl_crear.addMouseListener(this);
        init.lbl_slide.addMouseListener(this);
        reg.btn_reg.addActionListener(this);
        init.btn_reg.addActionListener(this);
        init.btn_add.addActionListener(this);
        init.btn_ver.addActionListener(this);
        init.btn_mod.addActionListener(this);
        init.tb_mostrar.addMouseListener(this);
        init.lbl_press.addMouseListener(this);
        init.pan_tab.addMouseListener(this);
        init.pan_form.addMouseListener(this);
        init.btn_del.addActionListener(this);
        log.lbl_close.addMouseListener(this);
        init.btn_set.addActionListener(this);
        mod.btn_camuser.addActionListener(this);
        init.btn_username.addActionListener(this);
        init.btn_email.addActionListener(this);
        init.btn_password.addActionListener(this);
        modEm.btn_cambemail.addActionListener(this);
        modpass.btn_campass.addActionListener(this);
        mod.lbl_cerraruser.addMouseListener(this);
        modEm.lbl_cerrarmail.addMouseListener(this);
        modpass.lbl_cerrarpass.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == log.btn_log) {
            init.pan_ajustes.setVisible(false);
            event.loguearse(log, sql, user, init);
            Inicio.lbl_user_id.setText(String.valueOf(user.getUserId()));
            init.lbl_username.setText(user.getUsername());

        } else if (ae.getSource() == reg.btn_reg) {
            event.registrarUser(reg, sql, user);

        } else if (ae.getSource() == init.btn_reg) {
            event.registrarWeb(init, web, websql);

        } else if (ae.getSource() == init.btn_add) {
            init.pan_form.setVisible(true);
            event.hidePanel(init);
            init.pan_tab.setVisible(false);
            init.pan_ajustes.setVisible(false);

        } else if (ae.getSource() == init.btn_ver) {
            event.hidePanel(init);
            TablaWebSite.ajustarTabla(init);
            init.pan_tab.setVisible(true);
            tb.mostrarWebs(init);
            init.pan_form.setVisible(false);
            init.pan_ajustes.setVisible(false);

        } else if (ae.getSource() == init.btn_mod) {
            event.updateWebs(init, websql, web);
            tb.mostrarWebs(init);

        } else if (ae.getSource() == init.btn_del) {
            event.deleteWeb(websql, init);
            tb.mostrarWebs(init);
        } else if (ae.getSource() == init.btn_set) {
            init.pan_form.setVisible(false);
            init.pan_tab.setVisible(false);
            init.pan_ajustes.setVisible(true);
        } else if (ae.getSource() == mod.btn_camuser) {
            event.updateUsername(mod, sql, user, init);
            init.lbl_username.setText(user.getUsername());
            mod.toFront();
        } else if (ae.getSource() == init.btn_username) {
            mod.txt_modname.setText(init.lbl_username.getText());
            mod.setVisible(true);
            
        } else if (ae.getSource() == modEm.btn_cambemail) {
            event.updateEmail(sql, user, init, modEm);
            modEm.toFront();
        } else if (ae.getSource() == init.btn_email) {
            modEm.txt_modemail.setText(sql.getDatos().get(1).toString());
            modEm.setVisible(true);
        } else if (ae.getSource() == init.btn_password) {
            modpass.txt_curpass.setText(sql.getDatos().get(2).toString());
            modpass.setVisible(true);
        } else if (ae.getSource() == modpass.btn_campass) {
            event.updatePassword(modpass, user, sql);//
            modpass.toFront();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int pos = this.init.lbl_slide.getX();
        if (me.getSource() == this.log.lbl_crear) {
            reg.setVisible(true);
        }
        if (me.getSource() == init.lbl_slide && pos > 20) {
            event.hidePanel(init);
        } else if (me.getSource() == init.lbl_slide && pos <= 20) {
            event.showPanel(init);
        } else if (me.getSource() == init.tb_mostrar) {
            event.hidePanel(init);
            event.mostrarDatos(init);
        } else if (me.getSource() == init.pan_form) {
            event.hidePanel(init);
        } else if (me.getSource() == init.pan_tab) {
            event.hidePanel(init);
        } else if (me.getSource() == log.lbl_close) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                System.exit(0);
            }
        } else if (me.getSource() == mod.lbl_cerraruser) {
            mod.dispose();
            
        } else if (me.getSource() == modEm.lbl_cerrarmail) {
            modEm.dispose();
        } else if (me.getSource() == modpass.lbl_cerrarpass) {
            modpass.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == init.lbl_press) {
            init.txt_fpass.setEchoChar((char) 0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == init.lbl_press) {
            init.txt_fpass.setEchoChar('•');
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
