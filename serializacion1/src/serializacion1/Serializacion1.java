/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion1;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Serializacion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MClase object1 = new MClase("Ola", -7, 2.7E10);
        MClase object2 = new MClase("Ola", 23, 2.7E10);
        
        File file = new File("serial");
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            
            oos.writeObject(object1);
            //oos.writeObject(object2);
            
            oos.close();
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            
            System.out.println(ois.readObject().toString());
            
            ois.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
