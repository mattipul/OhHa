/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiTestit;

import javax.swing.JComboBox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.gui.Vaikeustaso;
import tetrispeli.peli.Tetris;

/**
 *
 * @author matti
 */
public class VaikeusTasoTest {
    
    private Vaikeustaso vt;
    private Tetris tetris;
    private JComboBox vaikeudet;
    
    @Before
    public void setUp() {
        tetris = new Tetris();
        vaikeudet = new JComboBox();
        vt = new Vaikeustaso( tetris, vaikeudet );
    }
    
    @Test
    public void konstruktorinParametrit(){
        assertTrue( vt.getTetris()!=null);
        assertTrue( vt.getVaikeudet()!=null );
    }
    
}
