package PeliTestit;

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
import tetrispeli.peli.PeliPalkki;

/**
 *
 * @author matti
 */
public class TetrisPalkkiTest {
   
    private PeliPalkki palkki;
    
    @Before
    public void setUp() {
        palkki = new PeliPalkki(0, 0, "pun.png", 1);
    }
    
    @Test
    public void palkinKoordinaatitKunnossa(){
        assertTrue( palkki.getX()==0 && palkki.getY()==0 );
    }

    @Test
    public void palkinKuvaKunnossa(){
        assertTrue( palkki.getKuva().equals("pun.png") );
    }
    
    @Test
    public void palkinTyyppiKunnossa(){
        assertTrue( palkki.getTyyppi() == 1 );
    }
    
    @Test
    public void luokoPalkin(){
        assertTrue( palkki.getPalat().size()==4 );
    }
    
    @Test
    public void liikkuuAlussa(){
        assertTrue( palkki.liikuukoAlas() && palkki.liikuukoSivuttain() );
    }
    
    @Test
    public void liikkuuVasemmalle(){
        int x = palkki.getX();
        palkki.liikuVasemmalle();
        assertTrue(palkki.getX() == x-40);
    }
    
    @Test
    public void liikkuuOikealle(){
        int x = palkki.getX();
        palkki.liikuOikealle();
        assertTrue(palkki.getX() == x+40);
    }
    
    @Test
    public void liikkuuAlas(){
        int y= palkki.getY();
        palkki.liikuAlas(10);
        assertTrue(palkki.getY() == y+10);
    }
    
    @Test
    public void alasLiikkumattomaksi(){
        palkki.alasLiikkumattomaksi();
        assertTrue(palkki.liikuukoAlas()==false);
    }
    
    @Test
    public void sivulleLiikkumattomaksi(){
        palkki.sivulleLiikkumattomaksi();
        assertTrue(palkki.liikuukoSivuttain()==false);
    }
}
