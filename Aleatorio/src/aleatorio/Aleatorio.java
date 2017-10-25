/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Aleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] codes = {"p1", "p2", "p3"};
        String[] descripciones = {"parafusos", "cravos ", "tachas"};
        int[] prices = {3, 4, 5};

        File productos = new File("productos.txt");
        

        try {
            productos.createNewFile();
            RandomAccessFile raf = new RandomAccessFile(productos, "rw");
            long[] currentPosition = null;
            String descripcion = "";
            String codigo = "";
            int precio = 0;
            
            // Write
            for (int i = 0; i < 3; i++) {
                codigo = String.format("%-" + 3 + "s", codes[i]).replace(" ", "0");
                descripcion = String.format("%-" + 10 + "s", descripciones[i]).replace(" ", "0");
                precio = prices[i];
                System.out.println("Codigo: " + codigo 
                        + " descripcion: " + descripcion + " precio: " + precio);
                raf.writeChars(codigo);
                raf.writeChars(descripcion);
                raf.writeInt(precio); 
                
                System.out.println(raf.getFilePointer());
                
            }


            // Read
            
            codigo = "";
            raf.seek(30);
            for (int i = 0; i < 3; i++) {
                codigo += raf.readChar();
            }
            
            descripcion = "";
            for (int i = 0; i < 10; i++) {
                descripcion += raf.readChar();
            }
            
            
            precio = raf.readInt();
            
            System.out.println("Descripcion: " + descripcion.replace("0", "") + " codigo: " + codigo.replace("0", "") + " precio: " + precio);

            raf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(Aleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
