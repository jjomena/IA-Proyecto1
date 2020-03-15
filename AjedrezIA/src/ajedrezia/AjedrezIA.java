package ajedrezia;

import Vistas.TableroGUI;
import Modelos.ReadFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin
 */
public class AjedrezIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TableroGUI tb = new TableroGUI();
        tb.agregarComponentes();
        tb.setVisible(true);
    }
    
}
