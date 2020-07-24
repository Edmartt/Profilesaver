/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import java.awt.Image;
import javax.swing.ImageIcon;
import GUI.Registro;
/**
 *
 * @author sam
 */
public class StyleReg {
    ImageIcon ok;
    public void setIcon(Registro reg){
        ok = new ImageIcon(getClass().getResource("/img/okay.png"));
        reg.lbl_okay.setIcon(new ImageIcon(ok.getImage().getScaledInstance(reg.lbl_okay.getWidth(), reg.lbl_okay.getHeight(), Image.SCALE_AREA_AVERAGING)));
    }
    
}
