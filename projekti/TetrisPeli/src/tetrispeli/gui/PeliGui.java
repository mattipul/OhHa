
package tetrispeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import tetrispeli.peli.Palkki;
import tetrispeli.peli.Tetris;

public class PeliGui implements Runnable{
    
    private JFrame frame;
    private TetrisGrafiikka grafiikka;
    private Tetris peli;
    
    public PeliGui(Tetris peli){
        super();
        this.peli=peli;
    }

    @Override
    public void run() {
        frame = new JFrame("Tetris");    
        frame.setPreferredSize(new Dimension(700, 700));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
     public void luoKomponentit(Container container) {
        
        
        this.grafiikka = new TetrisGrafiikka(this.peli);
        container.add(this.grafiikka);
        
        NappaimistonKasittelija kasittelija = new NappaimistonKasittelija(this.peli);
        this.frame.addKeyListener(kasittelija);
        
        
       
    }
     
    public TetrisGrafiikka getGrafiikka() {
        return grafiikka;
    }
    
    
}
