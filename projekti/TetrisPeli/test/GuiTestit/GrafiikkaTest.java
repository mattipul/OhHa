/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.gui.TetrisGrafiikka;
import tetrispeli.peli.Tetris;

/**
 *
 * @author matti
 */
public class GrafiikkaTest {
    
    Tetris tetris;
    TetrisGrafiikka grf;
    
    @Before
    public void setUp() {
        tetris = new Tetris();
        grf = new TetrisGrafiikka(tetris);
    }
    
    @Test
    public void palauttaakoNollia(){
        assertTrue( grf.palautaNollia("10").length() == 8 );
    }
    
    @Test
    public void asettaakoTopPisteet(){
        String[] top = new String[10];
        top[0]="testiä";
        grf.setTopPisteet(top);
        assertTrue( grf.getTopPisteet()[0].equals("testiä") );
    }
}
