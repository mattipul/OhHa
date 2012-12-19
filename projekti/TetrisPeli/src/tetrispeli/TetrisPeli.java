
package tetrispeli;

import javax.swing.SwingUtilities;
import tetrispeli.gui.PeliGui;
import tetrispeli.peli.Tetris;


public class TetrisPeli {

    public static void main(String[] args) {
        
      Tetris peli = new Tetris();
 
        PeliGui gui = new PeliGui(peli);
        SwingUtilities.invokeLater(gui);

 
        while (gui.getGrafiikka() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                
            }
        }
        peli.setGrafiikka(gui.getGrafiikka());
        peli.start();
    }
}

