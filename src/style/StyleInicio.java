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

    ImageIcon us, men, show;

    public static void changeColor(Login log) {
        log.pan_login.setBackground(new Color(254, 254, 254, 100));
        log.lbl_crear.setBackground(new Color(0, 0, 0, 150));
        log.lbl_rec.setBackground(new Color(0, 0, 0, 150));
    }

    public void setImage(Inicio init) {
        us = new ImageIcon(getClass().getResource("/img/user.png"));
        init.lbl_user.setIcon(new ImageIcon(us.getImage().getScaledInstance(init.lbl_user.getWidth(), init.lbl_user.getHeight(), Image.SCALE_AREA_AVERAGING)));
        men = new ImageIcon(getClass().getResource("/img/menu.png"));
        init.lbl_slide.setIcon(new ImageIcon(men.getImage().getScaledInstance(init.lbl_slide.getWidth(), init.lbl_slide.getHeight(), Image.SCALE_AREA_AVERAGING)));
        show = new ImageIcon(getClass().getResource("/img/eye.png"));
        init.lbl_press.setIcon(new ImageIcon(show.getImage().getScaledInstance(init.lbl_press.getWidth(), init.lbl_press.getHeight(), Image.SCALE_AREA_AVERAGING)));
    }

    public static void setPlaceholder(Login log) {
        PlaceHolder usuario = new PlaceHolder(log.txt_name, new Color(0, 0, 0, 90), new Color(0, 0, 0, 150), "Usuario", false, "Bitstream Vera Serif", 12);
        PlaceHolder password = new PlaceHolder(log.txt_pass, new Color(0, 0, 0, 90), new Color(0, 0, 0, 150), "Password", false, "Bitstream Vera Serif", 12);
    }

}
