/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.Inicio;
import GUI.Login;
import GUI.ModEmail;
import GUI.ModPassword;
import GUI.ModUsername;
import Model.MetodosEventos;
import Model.Usuario.UserSQL;
import Model.Usuario.Usuario;
import Model.websites.TablaWebSite;
import Model.websites.WebSQL;
import Model.websites.WebSite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import style.StyleInicio;

/**
 *
 * @author sam
 */
public class ControllerInicio implements ActionListener, MouseListener, KeyListener {

    private Login cont;
    private Inicio init;
    private StyleInicio stylein;
    private ModUsername mod;
    private ModEmail modEm;
    private ModPassword modpass;
    private MetodosEventos event;
    private WebSite web;
    private WebSQL websql;
    private TablaWebSite tb;
    private Usuario user;
    private UserSQL sql;
    private Login log;

    public ControllerInicio(Inicio init) {
        this.init = init;
        mod = new ModUsername();
        modEm = new ModEmail();
        modpass = new ModPassword();
        init.pan_tab.setVisible(false);//Para que no se vea el panel de la tabla de datos
        init.pan_form.setVisible(false);//Para que no se vea el formulario al iniciar
        init.lbl_iconokay.setVisible(false);//Para que no se vea el icono de que la contraseña está bien al iniciar
        init.pan_slide.setBorder(new SoftBevelBorder(0, null, null, null, Color.black));//Ajustamos los bordes del panel lateral
        stylein = new StyleInicio();
        stylein.setImage(init);//Usamos el método para ajustar los iconos en los labels del login
        event = new MetodosEventos();
        web = new WebSite();
        websql = new WebSQL();
        user = new Usuario();
        sql = new UserSQL();
        websql = new WebSQL();
        web = new WebSite();
        tb = new TablaWebSite();
        log = new Login();
        buttons();
    }

    private void buttons() {

        init.btn_reg.addActionListener(this);
        init.lbl_add.addMouseListener(this);
        init.lbl_look.addMouseListener(this);
        init.btn_mod.addActionListener(this);
        init.tb_mostrar.addMouseListener(this);
        init.lbl_press.addMouseListener(this);
        init.pan_tab.addMouseListener(this);
        init.pan_form.addMouseListener(this);
        init.btn_del.addActionListener(this);
        init.lbl_set.addMouseListener(this);
        mod.btn_camuser.addActionListener(this);
        init.btn_username.addActionListener(this);
        init.btn_email.addActionListener(this);
        init.btn_password.addActionListener(this);
        modEm.btn_cambemail.addActionListener(this);
        modpass.btn_campass.addActionListener(this);
        mod.lbl_cerraruser.addMouseListener(this);
        modEm.lbl_cerrarmail.addMouseListener(this);
        modpass.lbl_cerrarpass.addMouseListener(this);
        init.txt_pass1.addKeyListener(this);
        init.lbl_off.addMouseListener(this);
        init.lbl_min.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == init.btn_reg) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea guardar este perfil?", "Guardar", JOptionPane.YES_NO_OPTION);

            if (resp == 0) {
                event.registrarWeb(init, web, websql);
            }

        } else if (ae.getSource() == init.btn_mod) {
            event.updateWebs(init, websql, web);
            tb.mostrarWebs(init);

        } else if (ae.getSource() == init.btn_del) {
            event.deleteWeb(websql, init);
            tb.mostrarWebs(init);
        } else if (ae.getSource() == mod.btn_camuser) {
            event.updateUsername(mod, sql, user, init);
            init.lbl_username.setText(user.getUsername());
            mod.toFront();
        } else if (ae.getSource() == init.btn_username) {
            mod.txt_curname.setText(init.lbl_username.getText());
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
            event.updatePassword(modpass, user, sql);
            modpass.toFront();
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == init.lbl_add) {
            init.pan_form.setVisible(true);
            init.pan_tab.setVisible(false);
            init.pan_ajustes.setVisible(false);
        } else if (me.getSource() == init.lbl_look) {
            TablaWebSite.ajustarTabla(init);
            init.pan_tab.setVisible(true);
            tb.mostrarWebs(init);
            init.pan_form.setVisible(false);
            init.pan_ajustes.setVisible(false);
        } else if (me.getSource() == init.lbl_set) {
            init.pan_form.setVisible(false);
            init.pan_tab.setVisible(false);
            init.pan_ajustes.setVisible(true);
        } else if (me.getSource() == init.lbl_min) {
            init.setExtendedState(Cursor.CROSSHAIR_CURSOR);
        } else if (me.getSource() == init.tb_mostrar) {
            event.mostrarDatos(init);
        } else if (me.getSource() == init.lbl_off) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

            if (resp == 0) {
                init.dispose();
                UserSQL.limpiar(init);
                //log.setVisible(true);
                cont=new Login(); //generamos la instancia del controlador del Login para volver al login con todos los eventos disponibles
            }
        } else if (me.getSource() == mod.lbl_cerraruser) {
            mod.dispose();
            init.toFront();
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

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == init.txt_pass1) {
            event.comparePass(init);
        }      
    }

}
