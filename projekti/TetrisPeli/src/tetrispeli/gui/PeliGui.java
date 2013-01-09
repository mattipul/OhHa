
package tetrispeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import tetrispeli.peli.Palkki;
import tetrispeli.peli.Tetris;

/**
 * Luokassa PeliGui luodaan pelissä käytettävät erilaiset graafiset komponentit ja luodaan tarvittava JFrame sekä liitetään TetrisGrafiikka siihen. 
 * @author matti
 */

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

    /**
     * Luodaan komponentit
     * JFrameen liitetään TetrisGrafiikka, joka saa parametrina PeliGuille annetun Tetriksen
     * Tämän lisäksi JFrameen liitetään myös Nappaimistonkasittelija, joka toimii näppäimistökuuntelijana
     */
    
     public void luoKomponentit(Container container) {
        
        
        this.grafiikka = new TetrisGrafiikka(this.peli);

        container.add(this.grafiikka);
        this.grafiikka.setLayout(null);
        
        String[] vaikeudetStr = { "Valitse vaikeustaso", "1", "2", "3", "4", "5" };
        
        JComboBox vaikeudet = new JComboBox(vaikeudetStr);
        vaikeudet.setSelectedIndex(0);
        vaikeudet.setBounds(500,600,150, 30);
        vaikeudet.setFocusable(false);
        vaikeudet.addActionListener(new Vaikeustaso(this.peli, vaikeudet));
        this.grafiikka.add(vaikeudet);
       
        
        NappaimistonKasittelija kasittelija = new NappaimistonKasittelija(this.peli);
        
        this.frame.addKeyListener(kasittelija);
        
        


    }
     
    public TetrisGrafiikka getGrafiikka() {
        return grafiikka;
    }
    
    
}
