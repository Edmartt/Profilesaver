package main;

import Extras.Tablas;
import controller.Controller;


/**
 *
 * @author sam
 */
public class Main {

    public static void main(String[] args) {
        Tablas tb=new Tablas();
        tb.crearTable();
        Controller cont = new Controller();
    }
}
