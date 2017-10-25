/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textodelimitado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class TextoDelimitado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String[] codigos = {"cod1", "cod2", "cod3"};
        String[] descripciones = {"parafusos", "cravos", "tachas"};
        double[] precios = {3, 4, 5};

        File productos = new File("productos.txt");
        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(new FileWriter(productos)));

            for (int i = 0; i < 3; i++) {
                pw.println(codigos[i] + "\t"
                        + descripciones[i] + "\t"
                        + precios[i]);
            }

            pw.close();

            BufferedReader bf = new BufferedReader(new FileReader(productos));
           
            Product producto = new Product();
            
            for (int i = 0; i < 3; i++) {
                String[] arrayLeido = bf.readLine().split("\t");
                producto.setCodigo(arrayLeido[0]);
                producto.setDescripcion(arrayLeido[1]);
                producto.setPrecio(Double.parseDouble(arrayLeido[2]));
                System.out.println(producto.toString());
            }
            bf.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No existe fichero");
        }

    }

}
