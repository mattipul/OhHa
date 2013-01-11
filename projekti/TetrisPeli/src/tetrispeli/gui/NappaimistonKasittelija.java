

package tetrispeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import tetrispeli.peli.Pala;
import tetrispeli.peli.Palkki;
import tetrispeli.peli.Tetris;

/**
 * NappimistoKasittelija on PeliGui:ssa käytettävä näppäimistönkuuntelija ja -käsittelijä.
 * Luokka kuuntelee näppäimistöä ja tarkistaa, onko painettu näppäin jokin pelissä käytettävistä.
 * Ja toimii tämän jälkeen näppäimestä riippuvalla tavalla.
 */

public class NappaimistonKasittelija implements KeyListener{
    
    /**
     * Käsiteltävä palkki
     */
    private Palkki palkki;
    /**
     * Käsittelijään liitettävä peliluokka
     */
    private Tetris peli;
    /**
     * Kertoo palkin aikaisemman suunnan
     */
    private int suuntaOli=0;
    
    /**
     *Näppäimistönkuuntelijan konstruktori
     */
    
    public NappaimistonKasittelija(Tetris peli){
        this.peli = peli;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }
    /**
     * Tarkastellaan, painetaanko nappia ja mitä nappia painetaan.
     * Painamalla enteriä peli käynnistetään
     * Välilyönti kääntää palkin
     * Ja nuolilla ohjataan palkkia vasemmalta oikealle ja toisinpäin
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(this.peli.getKaynnissa()==0){
            this.peli.setKaynnissa();
            }
            this.peli.setPisteet(0);
        }
        
        this.palkki = this.peli.getPalkit().get( this.peli.getPalkit().size()-1 );
        ArrayList<Pala> palat = this.palkki.getPalat();
        if(this.peli.kykeneekoLiikkumaanAlas()){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(this.peli.kykeneekoKaantymaan()){
            this.palkki.kaanna();
            }
        }
            
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
