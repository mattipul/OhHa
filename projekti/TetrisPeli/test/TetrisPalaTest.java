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
import tetrispeli.peli.Pala;

/**
 *
 * @author matti
 */
public class TetrisPalaTest {
    
    Pala pala;
    
    @Before
    public void setUp() {
        this.pala = new Pala(40,40,"pun.png");
    }
    
    @Test
    public void alkuKoordinaatitOikein(){
        assertTrue(pala.getX()==40 && pala.getY()==40);
    }
    
    @Test
    public void alkuKuvaOikein(){
        assertTrue(pala.getKuva()=="pun.png");
    }
    
    @Test
    public void liikkuukoAlas(){
        int y = pala.getY();
        pala.alas(11);
        assertTrue(pala.getY()==y+11);
    }
    
    @Test
    public void liikkuukoVasemmalle(){
        int x = pala.getX();
        pala.vasemmalle();
        assertTrue(pala.getX()==x-40);
    }
    
    @Test
    public void liikkuukoOikealle(){
        int x = pala.getX();
        pala.oikealle();
        assertTrue(pala.getX()==x+40);
    }


}
