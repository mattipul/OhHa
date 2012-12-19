
package tetrispeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import tetrispeli.peli.Pala;
import tetrispeli.peli.Palkki;
import tetrispeli.peli.Tetris;

public class NappaimistonKasittelija implements KeyListener{
    
    private Palkki palkki;
    private Tetris peli;
    private int suuntaOli=0;
    
    public NappaimistonKasittelija(Tetris peli){
        this.peli = peli;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.palkki = this.peli.getPalkit().get( this.peli.getPalkit().size()-1 );
        ArrayList<Pala> palat = this.palkki.getPalat();
        if(this.peli.kykeneekoLiikkumaanAlas()){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if( this.peli.kykeneekoLiikkumaanSivuttain() || this.suuntaOli==2){
                this.palkki.liikuVasemmalle();
                this.suuntaOli=1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        if( this.peli.kykeneekoLiikkumaanSivuttain() || this.suuntaOli==1){
            this.palkki.liikuOikealle();
            this.suuntaOli=2;
        }
        }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
}
