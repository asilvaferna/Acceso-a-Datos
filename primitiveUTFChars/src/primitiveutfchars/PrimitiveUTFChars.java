/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitiveutfchars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class PrimitiveUTFChars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File texto = new File("Texto.txt");
        DataOutputStream dataOutput = null;
        DataInputStream dataInput = null;

        try {
            // nuevo archivo
            texto.createNewFile();
            // nuevo output stream
            dataOutput = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(texto)));

            int cont1 = 0;
            int cont2 = 0;
            int cont3 = 0;
            

            for (int i = 0; i < 3; i++) {
                    String mensaje = "esta e unha cadea\n";
                if (i == 1) {
                    dataOutput.writeChars(mensaje);
                    System.out.println("writeChars ha escrito: " + mensaje);
                    cont2 = dataOutput.size() - cont1;
                    System.out.println("Nº de bytes: " + cont2 + " bytes");
                } else {
                    dataOutput.writeUTF(mensaje);
                    System.out.println("writeUTF ha escrito: " + mensaje);
                    if (i == 0) {
                        cont1 = dataOutput.size();
                        System.out.println("Nº de bytes: " + cont1 + " bytes");
                    } else {
                        cont3 = dataOutput.size() - cont2 - cont1;
                        System.out.println("Nº de bytes: " + cont3 + " bytes");
                    }
                }
            }
            System.out.println("Nº total de bytes: " + dataOutput.size());
            
            dataOutput.close();
            
            dataInput = new DataInputStream(new BufferedInputStream((new FileInputStream(texto))));
            
            int totalBytes = dataInput.available();
            
            String string1 = dataInput.readUTF();
            int readSize1 = totalBytes - dataInput.available();
            System.out.println("readUTF ha leido: " + string1);
            System.out.println("Bytes leidos: " + readSize1 + " bytes");
            
            int readSize2 = 0;
            String string2 = "";
            int charCount = dataInput.available() / 3;
            for (int i = 0; i < charCount; i++) {
                string2 += dataInput.readChar();
                readSize2 += 2;
            }
            System.out.println("readChar ha leido: " + string2);
            System.out.println("Bytes leidos: " + readSize2 + " bytes");
            
            String string3 = dataInput.readUTF();
            int readSize3 = (totalBytes - readSize2)/2 ;
            System.out.println("readUTF ha leido: " + string3);
            System.out.println("Bytes leidos: " + readSize3 + " bytes");
            
           
        } catch (IOException ex) {
            Logger.getLogger(PrimitiveUTFChars.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
