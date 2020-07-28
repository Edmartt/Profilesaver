package Model;

import Model.websites.WebSQL;
import Model.websites.WebSite;
import Model.Usuario.UserSQL;
import Model.Usuario.Usuario;
import Extras.SHA256;
import GUI.Inicio;
import GUI.Login;
import GUI.ModEmail;
import GUI.ModPassword;
import GUI.ModUsername;
import GUI.Registro;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
/**
 * La clase método eventos contiene métodos que llaman a otros métodos tales
 * como los métodos de la clase WebSQL, con el propósito de no cargar de código
 * la clase controlador y hacerla más legible. Algo más que tiene como objetivo
 * esta clase, es asignar los datos obtenidos en los distintos campos de texto
 * de la interfaz gráfica a los métodos setters y getters de las clases Website
 * y Usuario
 *
 */
public class MetodosEventos {

    public void loguearse(Login log, UserSQL sql, Usuario user, Inicio init) {
        user.setUsername(log.txt_name.getText());
        user.setPassword(SHA256.getSHA256(new String(log.txt_pass.getPassword())));
        sql.iniciarSesion(user, init, log);
    }

    public void registrarUser(Registro reg, UserSQL sql, Usuario user) {
        user.setUsername(reg.txt_nreg.getText());
        user.setEmail(reg.txt_email.getText());
        user.setPassword(SHA256.getSHA256(new String(reg.txt_passreg.getPassword())));

        if ((!reg.txt_email.getText().isBlank() && !reg.txt_nreg.getText().isBlank() && !new String(reg.txt_passreg.getPassword()).isBlank() && !new String(reg.txt_passconf.getPassword()).isBlank())) {
            if (sql.existeUsuario(user) == 0) {
                if (new String(reg.txt_passreg.getPassword()).length() >= 8) {
                    if (user.getPassword().equals(SHA256.getSHA256(new String(reg.txt_passconf.getPassword())))) {
                        int resp = JOptionPane.showConfirmDialog(null, "¿Desea crear el usuario?", "Crear", JOptionPane.YES_NO_OPTION);
                        if (resp == 0) {
                            sql.crearUsuario(user, reg);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                    }
                } else if (new String(reg.txt_passreg.getPassword()).length() < 8) {
                    JOptionPane.showMessageDialog(null, "La contraseña debe contener mínimo 8 caracteres");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        }
    }

    public void updateUsername(ModUsername mod, UserSQL usersql, Usuario user, Inicio init) {
        if (!mod.txt_confname.getText().isBlank()) {
            user.setUserId(Integer.parseInt(Inicio.lbl_user_id.getText()));
            user.setUsername(mod.txt_confname.getText());
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el nombre de usuario?", "Modificar", JOptionPane.YES_NO_OPTION);
            init.toBack();

            if (resp == 0) {
                usersql.modUsername(user);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe escribir un nombre de usuario en el campo");
        }
    }

    public void updateEmail(UserSQL usersql, Usuario user, Inicio init, ModEmail mod) {
        user.setUserId(Integer.parseInt(Inicio.lbl_user_id.getText()));
        user.setEmail(mod.txt_confemail.getText());
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el Email?", "Modificar", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            usersql.modEmail(user);
        }
    }

    public void updatePassword(ModPassword modpass, Usuario user, UserSQL usersql) {
        if (new String(modpass.txt_newpass.getPassword()).equals(new String(modpass.txt_conpass.getPassword()))) {
            user.setPassword(new String(modpass.txt_conpass.getPassword()));
            user.setUserId(Integer.parseInt(Inicio.lbl_user_id.getText()));
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea modificar su contraseña?", "Modificar", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                usersql.modPassword(user);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
    }

    public void registrarWeb(Inicio init, WebSite web, WebSQL websql) {
        web.setWeb_name(init.txt_url.getText());
        web.setWeb_username(init.txt_username.getText());
        web.setWeb_email(init.txt_email.getText());
        web.setWeb_pass(new String(init.txt_pass.getPassword()));
        web.setNota(init.txa_rnota.getText());
        if (!init.txt_url.getText().isBlank() && !init.txt_username.getText().isBlank() && !new String(init.txt_pass.getPassword()).isBlank() && !new String(init.txt_pass1.getPassword()).isBlank() && !init.txt_email.getText().isBlank()) {
            if (new String(init.txt_pass.getPassword()).equals(new String(init.txt_pass1.getPassword()))) {
                websql.agregarWeb(web, init);

            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
        }
    }

    public void comparePass(Object obj) {

        if (obj instanceof Inicio) {
            Inicio init = (Inicio) obj;
            if (!new String(init.txt_pass.getPassword()).equals(new String(init.txt_pass1.getPassword()))) {
                init.lbl_iconokay.setVisible(false);
                init.lbl_alert.setText("Las contraseñas no coinciden");
            } else {
                init.lbl_alert.setText(null);
                init.lbl_iconokay.setVisible(true);
            }
        } else if (obj instanceof Registro) {
            Registro reg = (Registro) obj;
            if (!new String(reg.txt_passreg.getPassword()).equals(new String(reg.txt_passconf.getPassword()))) {
                reg.lbl_okay.setVisible(false);
                reg.lbl_alert.setText("Las contraseñas no coinciden");
            } else {
                reg.lbl_alert.setText(null);
                reg.lbl_okay.setVisible(true);
            }
        }
    }

    public void updateWebs(Inicio init, WebSQL websql, WebSite web) {
        web.setWeb_name(init.txt_fname.getText());
        web.setWeb_username(init.txt_fusername.getText());
        web.setWeb_email(init.txt_femail.getText());
        web.setWeb_pass(new String(init.txt_fpass.getPassword()));
        web.setNota(init.txa_nota.getText());
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos?", "Actualizar", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            websql.actualizarWeb(web, init);
        }
    }

    public void deleteWeb(WebSQL websql, Inicio init) {
        int res = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este perfil?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (res == 0) {
            websql.eliminarWeb(init);
        }
    }

    public void mostrarDatos(Inicio init) {
        init.txt_fname.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 2).toString().trim());
        init.txt_fusername.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 3).toString().trim());
        init.txt_femail.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 4).toString().trim());
        init.txt_fpass.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 5).toString().trim());
        init.txa_nota.setText(init.tb_mostrar.getValueAt(init.tb_mostrar.getSelectedRow(), 6).toString().trim());
    }

}
