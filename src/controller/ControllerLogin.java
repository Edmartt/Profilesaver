package controller;

import GUI.Inicio;
import java.awt.event.ActionListener;
import GUI.Login;
import GUI.Registro;
import Model.MetodosEventos;
import Model.Usuario.UserSQL;
import Model.Usuario.Usuario;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import style.StyleReg;

/**
 *
 * @author sam
 */
/**
 * Esta clase es la encargada de gestionar las acciones llevadas a cabo por el
 * usuario del sistema, tales como clicks de botones, movimientos de mouse, que
 * deberían dar una respuesta concreta a la acción, lo que desata eventos.
 */
public class ControllerLogin implements ActionListener, MouseListener, KeyListener {

    private Login log;
    private Inicio init;
    private Usuario user;
    private Registro reg;
    private StyleReg stylereg;
    private UserSQL sql;
    private MetodosEventos event;
    private ControllerInicio contrInicio;

    /**
     * Método constructor. Generamos las instancias de los objetos que
     * iniciaremos, tales como las ventanas o los mensajes de ayuda según las
     * interacciones de usuario
     *
     */
    public ControllerLogin() {
        init = new Inicio();
        contrInicio = new ControllerInicio(init);
        reg = new Registro();
        stylereg = new StyleReg();
        stylereg.setIcon(reg);//Usamos el método para ajustarlos iconos en los labels de la ventana de registro de Usuario
        reg.lbl_okay.setVisible(false);
        event = new MetodosEventos();
        sql = new UserSQL();
        log = new Login();
        user = new Usuario();
        log.setVisible(true);
        buttons();
    }

    /**
     * Buttons es un método simple, que lo único que hace es contener las
     * acciones asignadas a cada boton, label y componente en general que serán
     * usadas, y evitar que nos genere un warning cuando asignamos el tipo de
     * acción que debe gestionar en el constructor
     */
    private void buttons() {
        log.btn_log.addActionListener(this);
        log.lbl_crear.addMouseListener(this);
        log.lbl_close.addMouseListener(this);
        log.lbl_iconeye.addMouseListener(this);
        log.lbl_iconeye.addMouseListener(this);
        log.txt_pass.addKeyListener(this);
        log.txt_pass.addMouseListener(this);
        log.txt_pass.addKeyListener(this);
        log.lbl_min.addMouseListener(this);
        log.btn_log.addKeyListener(this);
        log.txt_name.addKeyListener(this);
        reg.btn_reg.addActionListener(this);
        reg.lbl_closereg.addMouseListener(this);
        reg.btn_cancel.addActionListener(this);
        reg.txt_passconf.addKeyListener(this);
        reg.txt_nreg.addKeyListener(this);
    }

    /**
     * En este método solo se ejecutan las acciones según en el componente con
     * el que se esté interactuando.El método actionPerformed solo funciona con
     * botones. La serie de condicionales en el código se da según sea en un
     * botón en un formulario u otro
     *
     * @param ae el argumento de la clase ActionEvent para obtener la fuente de
     * la acción
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == log.btn_log) {
            event.loguearse(log, sql, user, init);
            Inicio.lbl_user_id.setText(String.valueOf(user.getUserId()));
        } else if (ae.getSource() == reg.btn_reg) {
            event.registrarUser(reg, sql, user);

        } else if (ae.getSource() == reg.btn_cancel) {
            int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar el registro?", "Cancelar", JOptionPane.YES_NO_OPTION);

            if (res == 0) {
                reg.dispose();
                UserSQL.limpiar(reg);
            }
        }
    }

    /**
     * Este método nos ayuda a gestionar las acciones de todos los componentes
     * que no sean botones, tales como labels.Acciones como dar click se
     * gestionan aquí con una serie de condicionales que según sea el componente
     * donde se desate la acción se obtendrá un resultado
     *
     * @param me argumento para obtener la fuente de la acción, es decir, en qué
     * componente se está dando la acción
     */
    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == this.log.lbl_crear) {
            reg.setVisible(true);
        } else if (me.getSource() == log.lbl_close) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION);

            if (resp == 0) {
                System.exit(0);
            }
        } else if (me.getSource() == log.lbl_min) {
            log.setExtendedState(Cursor.CROSSHAIR_CURSOR);
        } else if (me.getSource() == reg.lbl_closereg) {
            reg.dispose();
        }
    }

    /**
     * Gestiona todas las acciones o eventos que estén relacionados a mantener
     * el mouse presionado Puede también usarse para gestionar eventos de
     * clicks. En ambos casos de las condiciones lo que se pretende es que al
     * dar click y mantener presiona el mouse, se revele momentáneamente el
     * password (Al soltarlo volvería a su estado original)
     *
     * @param me argumento de clase MouseEvent para obtener la fuente del
     * eventoy asignar acción específica
     */
    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == log.lbl_iconeye) {
            log.txt_pass.setEchoChar((char) 0);
        }

    }

    /**
     * Gestiona acciones para cuando el click es soltado (Después de tenerlo
     * sostenido) Un click normal implica presionar y soltar.En el primer
     * condicional se especifica que al soltar el click en un label del
     * formulario de la ventana principal o Inicio (no login), en el campo de
     * password se mostrarán los caracteres en forma de puntos negros para ser
     * ocultado
     *
     * @param me argumento de clase MouseEvent para obtener la fuente de la
     * acción
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == log.lbl_iconeye) {
            log.txt_pass.setEchoChar('•');
        } else if (me.getSource() == log.txt_pass) {
            boolean activo = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

            if (activo) {
                log.message.setText("Mayúsculas está activado");
            } else if (activo == false) {
                log.message.setText(null);
            }
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

    /**
     * Al soltar la tecla desencada una acción según el componente en el que se
     * cumpla la condición
     *
     * @param ke argumento de clase KeyEvent para obtener la fuente de la acción
     *
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == reg.txt_passconf) {
            event.comparePass(reg);
        } //Se asigna el estado de la tecla a un boolean        
        else if (ke.getSource() == log.txt_pass) {
            boolean activo = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

            if (activo) {
                log.message.setText("Mayúsculas está activado");
            } else if (activo == false) {
                log.message.setText(null);
            }
        } else if (ke.getSource() == reg.txt_nreg) {

            if (event.prohibirChar(reg) == false) {
                reg.lbl_alert.setText("No se admiten caracteres raros");
            } else if (event.prohibirChar(reg)) {
                reg.lbl_alert.setText(null);
            }
        }
    }
}
