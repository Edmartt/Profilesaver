/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import GUI.Inicio;
import GUI.Login;
import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author sam
 */
/**
 * Esta clase contiene métodos para dar el estilo a la ventana Inicio. El estilo
 * implica el color, transparencia, ajuste de imagen al tamaño de un jLabel,
 * entre otros.
 */
public class StyleInicio {

    ImageIcon us, men, show, ad, lok, log, set, ok;

    public static void changeColor(Login log) {
        log.pan_login.setBackground(new Color(254, 254, 254, 100));
        log.lbl_crear.setBackground(new Color(0, 0, 0, 150));
        log.lbl_rec.setBackground(new Color(0, 0, 0, 150));
    }

    public void setImage(Inicio init) {
        us = new ImageIcon(getClass().getResource("/img/person-icon.png"));
        init.lbl_user.setIcon(new ImageIcon(us.getImage().getScaledInstance(init.lbl_user.getWidth(), init.lbl_user.getHeight(), Image.SCALE_AREA_AVERAGING))); 
        show = new ImageIcon(getClass().getResource("/img/eye2.png"));
        init.lbl_press.setIcon(new ImageIcon(show.getImage().getScaledInstance(init.lbl_press.getWidth(), init.lbl_press.getHeight(), Image.SCALE_AREA_AVERAGING)));
        ad = new ImageIcon(getClass().getResource("/img/edit.png"));
        init.lbl_icoadd.setIcon(new ImageIcon(ad.getImage().getScaledInstance(init.lbl_icoadd.getWidth(), init.lbl_icoadd.getHeight(), Image.SCALE_AREA_AVERAGING)));
        lok = new ImageIcon(getClass().getResource("/img/search.png"));
        init.lbl_iconlook.setIcon(new ImageIcon(lok.getImage().getScaledInstance(init.lbl_iconlook.getWidth(), init.lbl_iconlook.getHeight(), Image.SCALE_AREA_AVERAGING)));
        log = new ImageIcon(getClass().getResource("/img/calendar.png"));
        init.lbl_iconlog.setIcon(new ImageIcon(log.getImage().getScaledInstance(init.lbl_iconlog.getWidth(), init.lbl_iconlog.getHeight(), Image.SCALE_AREA_AVERAGING)));
        log = new ImageIcon(getClass().getResource("/img/engranaje.png"));
        init.lbl_iconset.setIcon(new ImageIcon(log.getImage().getScaledInstance(init.lbl_iconset.getWidth(), init.lbl_iconset.getHeight(), Image.SCALE_AREA_AVERAGING)));
        ok = new ImageIcon(getClass().getResource("/img/okay.png"));
        init.lbl_iconokay.setIcon(new ImageIcon(ok.getImage().getScaledInstance(init.lbl_iconokay.getWidth(), init.lbl_iconokay.getHeight(), Image.SCALE_AREA_AVERAGING)));

    }

    public static void setPlaceholder(Login log) {
        PlaceHolder usuario = new PlaceHolder(log.txt_name, new Color(0, 0, 0, 90), new Color(0, 0, 0, 150), "Usuario", false, "Bitstream Vera Serif", 12);
        PlaceHolder password = new PlaceHolder(log.txt_pass, new Color(0, 0, 0, 90), new Color(0, 0, 0, 150), "Password", false, "Bitstream Vera Serif", 12);
    }

}
