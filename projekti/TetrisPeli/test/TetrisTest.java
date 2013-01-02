/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.peli.Tetris;

/**
 *
 * @author matti
 */
public class TetrisTest {
    
    Tetris tetris;

    @Before
    public void setUp() {
        tetris = new Tetris();
    }
    
    @Test
    public void alkuPisteet(){
        assertTrue(tetris.getPisteet()==0);
    }     
    
    @Test
    public void arpooVarin(){
        String vari = tetris.arvoVari();
        for(int i=0; i<100; i++){
        assertTrue( vari.equals("pun.png") || vari.equals("tummsin.png") || vari.equals("vaalsin.png") || vari.equals("kelt.png") || vari.equals("vihr.png") );
        }
    }
    
    @Test
    public void arpooTyypin(){
        for(int i=0; i<100; i++){
            int testityyppi = tetris.arvoTyyppi();
            assertTrue( testityyppi>=0 && testityyppi<=6 );
        }
    }
    
    @Test
    public void hakeekoPeliPalat(){
        assertTrue(tetris.getPeliPalat() != null); 
    }
    
    @Test
    public void hakeekoPalkit(){
        assertTrue(tetris.getPalkit() != null); 
    }
    
    @Test
    public void lisaakoPalkin(){
        int esize = tetris.getPalkit().size();
        tetris.lisaaPala();
        assertTrue(tetris.getPalkit().size()==esize+1);
    }
    
    @Test
    public void onkoKaynnissa(){
        assertTrue(tetris.getKaynnissa()==0);
    }
    
    @Test
    public void lopetaOnkoNytKaynnissa(){
        tetris.setPaattyi();
        assertTrue(tetris.getKaynnissa()==0);
    }
    
    @Test
    public void onkoKaynnistyksenJalkeenKaynnissa(){
        tetris.setKaynnissa();
        assertTrue(tetris.getKaynnissa()==1);
    }
    
}
