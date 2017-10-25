/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitivewriteutf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class PrimitiveWriteUTF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        File texto = new File("Texto.txt");

        DataOutputStream dataOutput = null;
        DataInputStream dataInput = null;

        try {
            // nuevo archivo
            texto.createNewFile();

            // nuevo output stream
            dataOutput = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(texto)));

            // inicializamos contador para contabilizar el tamaño en bytes del stream
            int cont = 0;

            for (int i = 0; i < 2; i++) {
                String mensaje = "Esta es una prueba";
                dataOutput.writeUTF(mensaje);
                System.out.println("writeUTF ha escrito: " + mensaje);
                System.out.println("Nº de bytes: " + dataOutput.size() / (i + 1) + " bytes");
                if (i == 1) {
                    cont = dataOutput.size();
                }
            }
            System.out.println("Nº total de bytes: " + cont);

            // cerramos el stream de datos
            dataOutput.close();

            // para crear el input stream que nos permitira leer el contenido del fichero
            dataInput = new DataInputStream(new BufferedInputStream((new FileInputStream(texto))));

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    System.out.println("Primera cadena: " + dataInput.readUTF());
                    // el metodo 'avaliable()' nos retorna una estimacion del numero de bytes restantes en el fichero 
                    System.out.println("Bytes restantes: " + dataInput.available() + " bytes");
                } else {
                    System.out.println("Segunda cadena: " + dataInput.readUTF());
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IOException");
        } finally {
            try {
                if (dataOutput != null) {
                    dataOutput.close();
                }

                if (dataInput != null) {
                    dataInput.close();
                }
            } catch (IOException ex) {
                System.out.println("IOException 2");
            }
        }

    }

}
