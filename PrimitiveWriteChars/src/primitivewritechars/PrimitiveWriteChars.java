package primitivewritechars;

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
public class PrimitiveWriteChars {

    public static void main(String[] args) {

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
                String mensaje = "esta e unha cadea\n";
                dataOutput.writeChars(mensaje);
                System.out.println("writeChars ha escrito: " + mensaje);
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

            String mensajeChar = "";
            
            while (dataInput.available() > 0) {
                mensajeChar += dataInput.readChar();
            }
            
            System.out.println("Primera cadena: " + mensajeChar);
            System.out.println("Bytes totales: " + texto.length() + " bytes");

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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
