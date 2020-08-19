package main;


import Extras.Tablas;

import controller.ControllerLogin;


/**
 *
 * @author sam
 */
public class Main {

    public static void main(String[] args) {
        Tablas tb=new Tablas();
        tb.crearTable();
        ControllerLogin cont = new ControllerLogin();
    }
}
