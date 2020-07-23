/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import GUI.Login;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import com.placeholder.PlaceHolder;
import java.awt.Font;

/**
 *
 * @author sam
 */
/**
 * Esta clase contiene métodos para dar el estilo a la ventana Login. El estilo
 * implica el color, transparencia, ajuste de imagen al tamaño de un jLabel,
 * entre otros.
 */
public class StyleLogin {

    ImageIcon back, us, pas, ey,logo;

    public static void changeColor(Login log) {
        log.pan_login.setBackground(new Color(17, 138, 178));
        log.lbl_crear.setBackground(new Color(0, 0, 0, 150));
        log.lbl_rec.setBackground(new Color(0, 0, 0, 150));
    }

    public void setImage(Login log) {
        back = new ImageIcon(getClass().getResource("/img/Mind Universe 2.jpg"));
        log.lbl_fondo.setIcon(new ImageIcon(back.getImage().getScaledInstance(log.lbl_fondo.getWidth(), log.lbl_fondo.getHeight(), Image.SCALE_AREA_AVERAGING)));
        us = new ImageIcon(getClass().getResource("/img/usuario.png"));
        log.lbl_iconuser.setIcon(new ImageIcon(us.getImage().getScaledInstance(log.lbl_iconuser.getWidth(), log.lbl_iconuser.getHeight(), Image.SCALE_AREA_AVERAGING)));
        pas = new ImageIcon(getClass().getResource("/img/password.png"));
        log.lbl_iconpass.setIcon(new ImageIcon(pas.getImage().getScaledInstance(log.lbl_iconpass.getWidth(), log.lbl_iconpass.getHeight(), Image.SCALE_AREA_AVERAGING)));
        ey = new ImageIcon(getClass().getResource("/img/eye.png"));
        log.lbl_iconeye.setIcon(new ImageIcon(ey.getImage().getScaledInstance(log.lbl_iconeye.getWidth(), log.lbl_iconeye.getHeight(), Image.SCALE_AREA_AVERAGING)));
        logo = new ImageIcon(getClass().getResource("/img/log.png"));
        log.lbl_logo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(400, 200, Image.SCALE_AREA_AVERAGING)));

    }

    public static void setPlaceholder(Login log) {
        Font f = new Font("AvanGarde LT Medium", Font.BOLD, 14);
        PlaceHolder usuario = new PlaceHolder(log.txt_name, new Color(254, 254, 254, 180), new Color(254, 254, 254), "Usuario", false, "AvanGarde LT Medium", 14);
        PlaceHolder password = new PlaceHolder(log.txt_pass, new Color(254, 254, 254, 180), new Color(254, 254, 254), "Password", false, "Bitstream Vera Serif", 14);
    }

}
