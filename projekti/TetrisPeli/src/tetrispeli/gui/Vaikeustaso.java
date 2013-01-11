/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import tetrispeli.peli.Tetris;

/**Vaikeustasoa säätelevän comboboxin toiminnankuuntelija
 *
 * @author matti
 */
public class Vaikeustaso implements ActionListener{
    
    /**
     * Pelilogiikan sisältävä olio. Tämä olio haluaa tietää käytettävän vaikeustason
     */
    private Tetris tetris;
    /**
     * Kuunneltava Combobox
     */
    private JComboBox vaikeudet;

    /**
     * Paulauttaa this.tetris
     * @return 
     */
    public Tetris getTetris() {
        return tetris;
    }

    /**
     * Palauttaa this.vaikeudet
     * @return 
     */
    public JComboBox getVaikeudet() {
        return vaikeudet;
    }
    
    /**
     * Vaikeustason konstruktori
     * @param tetris
     * @param vaikeudet 
     */
    
    public Vaikeustaso(Tetris tetris, JComboBox vaikeudet){
           this.tetris=tetris;  
           this.vaikeudet=vaikeudet;
    }

    /**
     * Mitä tehdään kun toimitaan? Säädellään vaikeustasoa pelaajan haluamalla tasolla akselilla 1-5
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vaikeudet.getSelectedIndex() ==0 ){
            this.vaikeudet.setSelectedIndex(1);
        }
        
        if(this.vaikeudet.getSelectedIndex() ==1 ){
            this.tetris.setVaikeustaso(150);
        }
        
        if(this.vaikeudet.getSelectedIndex() ==2 ){
            this.tetris.setVaikeustaso(100);
        }
        
       if(this.vaikeudet.getSelectedIndex() ==3 ){
            this.tetris.setVaikeustaso(70);
        }
       
        if(this.vaikeudet.getSelectedIndex() ==4 ){
            this.tetris.setVaikeustaso(30);
        }
        
        if(this.vaikeudet.getSelectedIndex() ==5 ){
            this.tetris.setVaikeustaso(1);
        }
    }
    
}
