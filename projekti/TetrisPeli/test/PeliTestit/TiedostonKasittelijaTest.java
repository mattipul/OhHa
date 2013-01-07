/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PeliTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.peli.TiedostonKasittelija;

/**
 *
 * @author matti
 */
public class TiedostonKasittelijaTest {
    
    TiedostonKasittelija tk;
    
    @Before
    public void setUp() {
        tk = new TiedostonKasittelija("testi.txt");
    }
    
    @Test
    public void onkoOikeaTiedostoNimi(){
        assertTrue(tk.getTiedosto().equals("testi.txt"));
    }

}
