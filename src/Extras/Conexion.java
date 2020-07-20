
package Extras;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
/**
 * La clase Conexión nos provee de
 * un único método que es el que nos permite
 * conectarnos a nuestra bd
 */
public class Conexion {
    private static Connection con=null;
    
    public static Connection getConnection(){
        if(con==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost/websites","root","Yankeeman123*");
                System.out.println("Conexión realizada");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No hay conexión, verifique contraseña o BD");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        return con;
    
    
    }
    
  
    
    
}
