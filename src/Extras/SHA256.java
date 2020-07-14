/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
/**
 * Nos provee de un único método para lograr cifrado SHA2
 */
public class SHA256 {
    public static String getSHA256(String input){
        String toReturn=null;
        try{
            MessageDigest digest= MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf-8"));
            toReturn=String.format("%064x", new BigInteger(1,digest.digest()));
        }
        catch(UnsupportedEncodingException | NoSuchAlgorithmException e){
            JOptionPane.showMessageDialog(null, e);
            }
        
        
             
        
        return toReturn;
    
        }
}
