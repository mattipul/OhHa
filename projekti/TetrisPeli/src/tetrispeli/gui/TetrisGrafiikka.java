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

public class TetrisGrafiikka extends JPanel {

    private Tetris peli;

    public TetrisGrafiikka(Tetris peli) {
        this.peli = peli;
    }

    public void paivita() {
        super.repaint();
    }
    
    public String palautaNollia(String luku){
        String nollat="";
        for(int i=0; i<10-luku.length(); i++){
            nollat = nollat + "0";
        }
        return nollat;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img = null;        
        
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
        }
        
        ArrayList<Pala> pelipalat = this.peli.getPeliPalat();
        
        for (int i = 0; i < pelipalat.size(); i++) {

            try {
                img = ImageIO.read(new File(pelipalat.get(i).getKuva()));
            } catch (IOException e) {
            }
            g.drawImage(img, pelipalat.get(i).getX(), pelipalat.get(i).getY(), null);
        }


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
}
