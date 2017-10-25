/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion2;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Serializacion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        Double[] prezo = {3.0, 4.0, 5.0};
        ObjectInputStream ois = null;
        try {

            File file = new File("Serializados");
            oos = new ObjectOutputStream(new FileOutputStream(file));

            for (int i = 0; i < cod.length; i++) {
                Product p1 = new Product(cod[i], desc[i], prezo[i]);
                oos.writeObject(p1);
            }

            oos.close();

            ois = new ObjectInputStream(new FileInputStream(file));

            while (true) {
                System.out.println(ois.readObject().toString());
            }

        } catch (EOFException e){
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException closeException) {
                closeException.printStackTrace();
            }
        }

    }
}
