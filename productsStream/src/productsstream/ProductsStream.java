/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productsstream;

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
public class ProductsStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Product p1 = new Product("cod1", "parafusos", 3);
        Product p2 = new Product("cod2", "arandelas", 4);

        File texto = new File("Texto.txt");

        DataOutputStream dataOutput = null;
        DataInputStream dataInput = null;

        try {
            // nuevo archivo
            texto.createNewFile();

            // nuevo output stream
            dataOutput = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(texto)));

            // objeto 1
            dataOutput.writeUTF(p1.getCodigo());
            dataOutput.writeUTF(p1.getDescripcion());
            dataOutput.writeDouble(p1.getPrecio());
            dataOutput.flush();
            // objeto 2
            dataOutput.writeUTF(p2.getCodigo());
            dataOutput.writeUTF(p2.getDescripcion());
            dataOutput.writeDouble(p2.getPrecio());
            dataOutput.close();

            dataInput = new DataInputStream(new BufferedInputStream((new FileInputStream(texto))));

            // objeto 1
            /*System.out.println("Objeto 1:\nCodigo: " + dataInput.readUTF()
             + "\nDescripcion: " + dataInput.readUTF()
             + "\nPrecio: " + dataInput.readDouble() + "€\n");

             //objeto 2
             System.out.println("Objeto 2:\nCodigo: " + dataInput.readUTF()
             + "\nDescripcion: " + dataInput.readUTF()
             + "\nPrecio: " + dataInput.readDouble() + "€");
             */
            Product p3 = new Product();

            for (int i = 0; i < 2; i++) {
                p3.setCodigo(dataInput.readUTF());
                p3.setDescripcion(dataInput.readUTF());
                p3.setPrecio(dataInput.readDouble());
                System.out.println("Objeto:\nCodigo: " + p3.getCodigo()
                        + "\nDescripcion: " + p3.getDescripcion()
                        + "\nPrecio: " + p3.getPrecio() + "€\n");
            }
            dataInput.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {

        }

    }

}
