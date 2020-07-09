/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sam
 */
public class Limpieza {

    /**
     * *
     * Método estático usado para limpiar la pantalla según el Sistema Operativo
     * cambia el comando
     *
     */
    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            System.out.println(os);
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");

            } else if (os.contains("Linux")) {
                Runtime.getRuntime().exec("clear");

            }
            
           

        } catch (IOException e) {
            System.out.println(e);
        }

    }
    


}
