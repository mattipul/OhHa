package tetrispeli.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import tetrispeli.peli.Pala;
import tetrispeli.peli.Palkki;
import tetrispeli.peli.Tetris;

/**
 * Tässä luokassa piirretään kaikki palkit, pisteet, top-lista, logo sekä peliä ohjaavaa tekstiä.
 * @author matti
 */

public class TetrisGrafiikka extends JPanel {

    private Tetris peli;
    private String[] toppisteet;

    public TetrisGrafiikka(Tetris peli) {
        this.peli = peli;
    }

    public void paivita() {
        super.repaint();
    }
    
    /**
     * Palautetaan pisteiden eteen tulevat nollat
     * @param luku pisteet
     * @return nollat 10-pisteet
     */
    
    public String palautaNollia(String luku){
        String nollat="";
        for(int i=0; i<10-luku.length(); i++){
            nollat = nollat + "0";
        }
        return nollat;
    }
    
    /**
     * Asetetaan toppisteet
     * @param toppisteet pisteet taulukossa
     */
    
    public void setTopPisteet(String[] toppisteet){
        this.toppisteet=toppisteet;
    }
    
    public String[] getTopPisteet(){
        return this.toppisteet;
    }
    
    /**
     * Piirretään top10-lista
     */
    
    public void topPisteet(Graphics g){
         g.drawString("Kymmenen parasta:", 490, 332);
        for(int i=0; i<10; i++){
            g.drawString((i+1)+". " + this.toppisteet[i], 490, 352+20*i);
        }
    }
    
    /**
     * Piirretään tekstiä sivuun kertomaan, että peli on päättynyt
     * Piirretään myös saavutettu pistemäärä
     */
    
    public void piirraKunPeliOnPaattynyt(Graphics g){
            g.drawString("Peli on päättynyt!", 490, 260);
            g.drawString("Sait " + this.peli.getLoppuPisteet() + " pistettä.", 490, 292);
            topPisteet(g);
    }
    
    /**
     * Piirretään Tetris-logo
     * Sekä myös päivitettävä, nykyisen pelin pistemäärä
     */
    
    public void logoJaPisteet(BufferedImage img,Graphics g){
      String pisteet=""+this.peli.getPisteet();
        
         try {
                img = ImageIO.read(new File("logo.png"));
            } catch (IOException e) {
            }
        g.drawImage(img, 480, 10, null);
        g.setFont(new Font("sansserif", Font.BOLD, 32));
        g.drawString(palautaNollia(pisteet)+pisteet, 500, 150);
    }
    
    /**
     * Tässä käyettään aikaisempaa piirraKunPeliOnPaattynyt() -metodia
     * Tätä metodia kutsutaan aina kun peli on valmis aloitettavaksi
     */
    
    public void piirraSivusta(BufferedImage img, Graphics g){
        logoJaPisteet(img,g);
        g.setFont(new Font("sansserif", Font.BOLD, 17));
        if(this.peli.getKaynnissa()==0){
            g.drawString("Aloita painamalla enteriä", 490, 200);
        }
        if(this.peli.getPaattynyt()==1){
          piirraKunPeliOnPaattynyt(g);
        }
    }
    
    /**
     * Piirretään harmaat palkit, eli pelialueen rajat
     */
    
    public void piirraPeliPalat(BufferedImage img, Graphics g){
       ArrayList<Pala> pelipalat = this.peli.getPeliPalat();
        
        for (int i = 0; i < pelipalat.size(); i++) {

            try {
                img = ImageIO.read(new File(pelipalat.get(i).getKuva()));
            } catch (IOException e) {
            }
            g.drawImage(img, pelipalat.get(i).getX(), pelipalat.get(i).getY(), null);
        }
    }
    
    /**
     * Piirretään tetrispalkit
     */
    
    public void piirraPalkit(BufferedImage img, Graphics g){
             ArrayList<Palkki> palat = this.peli.getPalkit();
        for (int i = 0; i < palat.size(); i++) {
            
            ArrayList<Pala> palanpalkit = palat.get(i).getPalat();
            
            for (int ii = 0; ii < palanpalkit.size(); ii++) {
                
                try {
                    img = ImageIO.read(new File(palanpalkit.get(ii).getKuva()));
                } catch (IOException e) {
                }
                
                g.drawImage(img, palanpalkit.get(ii).getX(), palanpalkit.get(ii).getY(), null);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img = null;        
        
        /*
        String pisteet=""+this.peli.getPisteet();
        
         try {
                img = ImageIO.read(new File("logo.png"));
            } catch (IOException e) {
            }
        g.drawImage(img, 480, 10, null);
        g.setFont(new Font("sansserif", Font.BOLD, 32));
        g.drawString(palautaNollia(pisteet)+pisteet, 500, 150);
        g.setFont(new Font("sansserif", Font.BOLD, 17));
        if(this.peli.getKaynnissa()==0){
            g.drawString("Aloita painamalla enteriä", 490, 200);
        }
        if(this.peli.getPaattynyt()==1){
            g.drawString("Peli on päättynyt!", 490, 260);
            g.drawString("Sait " + this.peli.getLoppuPisteet() + " pistettä.", 490, 292);
            topPisteet(g);
        }
*/
        piirraSivusta(img, g);
        
        piirraPeliPalat(img, g);

        
        piirraPalkit(img, g);
        
    }
}
