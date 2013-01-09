/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import tetrispeli.peli.Tetris;

/**
 *
 * @author matti
 */
public class Vaikeustaso implements ActionListener{
    
    private Tetris tetris;
    private JComboBox vaikeudet;
    
    public Vaikeustaso(Tetris tetris, JComboBox vaikeudet){
           this.tetris=tetris;  
           this.vaikeudet=vaikeudet;
    }

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
