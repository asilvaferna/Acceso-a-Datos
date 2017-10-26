/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlproba0ler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author oracle
 */
public class XMLproba0ler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        XMLInputFactory xmlinf = XMLInputFactory.newInstance();
        
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
        
        try {
            XMLStreamReader xmlsr = xmlinf.createXMLStreamReader(new FileReader("../XMLProba0/autores.xml"));
            while (xmlsr.hasNext()) {
                int eventType = xmlsr.next();
                switch (eventType) {
                    case XMLStreamReader.START_ELEMENT:
                        //System.out.println("<" + xmlsr.getLocalName() + ">");
                        String elementName = xmlsr.getLocalName();
                        if (elementName.equals("autor")) {
                            System.out.println("<" + xmlsr.getLocalName() + " " + xmlsr.getAttributeLocalName(0) + " ='" + xmlsr.getAttributeValue(0) +"'>");
                            
                        } else {
                            System.out.println("<" + xmlsr.getLocalName() + ">");
                        }
                        break;
                    case XMLStreamReader.CHARACTERS:
                        System.out.println(xmlsr.getText());
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        System.out.println("</" + xmlsr.getLocalName() + ">");
                        break;
                        
                }
            }

            
            xmlsr.close();
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLproba0ler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLproba0ler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static String readCharacters(XMLStreamReader reader) {
        
        
        return null;
        
    }
    
}
