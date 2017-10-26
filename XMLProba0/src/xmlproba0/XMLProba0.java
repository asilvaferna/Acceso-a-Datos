/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlproba0;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.*;

/**
 *
 * @author oracle
 */
public class XMLProba0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        XMLOutputFactory xmlouf = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter xmlsw = xmlouf.createXMLStreamWriter(new FileWriter("autores.xml"));

            /*<?xm version="1.0"?>
             <autores>
             <autor codigo ="a1">
             <nome>Alexandre Dumas </nome>
             <titulo> El conde de montecristo</titulo>
             <titulo> Los miserables </titulo>
             </autor>
             <autor codigo ="a2">
             <nome>Fiodor Dostoyevski</nome>
             <titulo> El idiota</titulo>
             <titulo> Noches blancas </>
             </autor>
             <autores>*/
            xmlsw.writeStartDocument("1.0"); //escribe a declaracion XML con a Version especificada

            xmlsw.writeStartElement("autores"); // abre <autores>
            xmlsw.writeStartElement("autor"); // abre <autor>
            xmlsw.writeAttribute("codigo", "a1"); // <autor codigo ="a1">
            xmlsw.writeStartElement("nome"); // abre <nome>
            xmlsw.writeCharacters("Alexandre Dumas"); // <nome>Alexandre Dumas </nome>
            xmlsw.writeEndElement(); // cierra <nome>
            xmlsw.writeStartElement("titulo"); // abre <titulo>
            xmlsw.writeCharacters("El conde de montecristo"); // <titulo> El conde de montecristo</titulo>
            xmlsw.writeEndElement(); // cierra <titulo>
            xmlsw.writeStartElement("titulo"); // abre <titulo>
            xmlsw.writeCharacters("Los miserables"); // <titulo> Los miserables</titulo>
            xmlsw.writeEndElement(); // cierra <titulo>
            xmlsw.writeEndElement(); // cierra <autor>

            xmlsw.writeStartElement("autor"); // abre <autor>
            xmlsw.writeAttribute("codigo", "a2"); // <autor codigo ="a2">
            xmlsw.writeStartElement("nome"); // abre <nome>
            xmlsw.writeCharacters("Fiodor Dostoyevski"); // <nome>Fiodor Dostoyevski</nome>
            xmlsw.writeEndElement(); // cierra <nome>
            xmlsw.writeStartElement("titulo"); // abre <titulo>
            xmlsw.writeCharacters("El idiota"); // <titulo> El idiota</titulo>
            xmlsw.writeEndElement(); // cierra <titulo>
            xmlsw.writeStartElement("titulo"); // abre <titulo>
            xmlsw.writeCharacters("Noches blancas"); // Noches blancas</titulo>
            xmlsw.writeEndElement(); // cierra <titulo>
            xmlsw.writeEndElement(); // cierra <autor>

            xmlsw.writeEndElement(); // cierra autores
            
            xmlsw.flush();
            xmlsw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(XMLProba0.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLProba0.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
