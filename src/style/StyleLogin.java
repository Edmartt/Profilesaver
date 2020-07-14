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

/**
 *
 * @author sam
 */
/**
 * Esta clase contiene métodos para dar el estilo a la ventana Login.
 * El estilo implica el color, transparencia, ajuste de imagen al
 * tamaño de un jLabel, entre otros.
 */
public class StyleLogin {

    ImageIcon back;

    public static void changeColor(Login log) {
        log.pan_login.setBackground(new Color(17, 138, 178));
        log.lbl_crear.setBackground(new Color(0, 0, 0, 150));
        log.lbl_rec.setBackground(new Color(0, 0, 0, 150));
    }

    public void setImage(Login log) {
        back = new ImageIcon(getClass().getResource("/img/Mind Universe 2.jpg"));
        log.lbl_fondo.setIcon(new ImageIcon(back.getImage().getScaledInstance(log.lbl_fondo.getWidth(), log.lbl_fondo.getHeight(), Image.SCALE_AREA_AVERAGING)));

    }

    public static void setPlaceholder(Login log) {
        PlaceHolder usuario = new PlaceHolder(log.txt_name, new Color(0, 0, 0, 90), new Color(0, 0, 0, 150), "Usuario", false, "Bitstream Vera Serif", 12);
        PlaceHolder password = new PlaceHolder(log.txt_pass, new Color(0, 0, 0, 90), new Color(0, 0, 0, 150), "Password", false, "Bitstream Vera Serif", 12);

    }

}
