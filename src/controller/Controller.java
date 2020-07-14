package controller;

import GUI.Inicio;
import java.awt.event.ActionListener;
import GUI.Login;
import GUI.Registro;
import Model.MetodosEventos;
import Model.SQL;
import Model.TablaWebSite;
import Model.Usuario;
import Model.WebSQL;
import Model.WebSite;
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
public class Controller implements ActionListener, MouseListener {

    private Login log;
    private Inicio init;
    private Usuario user;
    private Registro reg;
    private SQL sql;
    private MetodosEventos event;
    private WebSQL websql;//métodos para SQL Website
    private WebSite web;
    private TablaWebSite tb;
    private StyleInicio stylein;

    public Controller() {
        this.reg = new Registro();
        this.event = new MetodosEventos();
        this.sql = new SQL();
        this.log = new Login();
        this.init = new Inicio();
        this.stylein = new StyleInicio();
        this.websql = new WebSQL();
        this.web = new WebSite();
        stylein.setImage(init);
        this.init.pan_tab.setVisible(false);
        this.tb = new TablaWebSite();
        this.init.pan_form.setVisible(false);
        this.init.pan_slide.setBorder(new SoftBevelBorder(0, null, null, null, Color.black));
        this.user = new Usuario();
        this.log.setVisible(true);

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
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.log.btn_log) {
            event.loguearse(this.log, this.sql, this.user, this.init);
            Inicio.lbl_user_id.setText(String.valueOf(this.user.getUserId()));
            this.init.lbl_username.setText(user.getUsername());
        } else if (ae.getSource() == this.reg.btn_reg) {
            event.registrarUser(reg, sql, user);

        } else if (ae.getSource() == init.btn_reg) {
            event.registrarWeb(init, web, websql);
        } else if (ae.getSource() == init.btn_add) {
            init.pan_form.setVisible(true);
            event.hidePanel(init);
            init.pan_tab.setVisible(false);

        } else if (ae.getSource() == init.btn_ver) {
            event.hidePanel(init);
            TablaWebSite.ajustarTabla(init);
            init.pan_tab.setVisible(true);
            tb.mostrarWebs(init);

            init.pan_form.setVisible(false);
        } else if (ae.getSource() == init.btn_mod) {
            websql.actualizarDatos(init);

        } else if (ae.getSource() == init.btn_del) {
            websql.eliminarWeb(init);

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
            int resp = JOptionPane.showConfirmDialog(null, "Desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                System.exit(0);
            }

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
