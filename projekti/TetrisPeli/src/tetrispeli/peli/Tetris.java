package tetrispeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import tetrispeli.gui.TetrisGrafiikka;

/**
 * Pelin ns. pääluokka. Sisältää pelimekaniikkaan liittyviä metodeja, jotka hoitavat hommia kuten täydellisten rivien tarkistaminen, pelikentän alustaminen ja palkkien järjestyksen ja liikkumisen hallinointi.
 * @author matti
 */

public class Tetris extends Timer implements ActionListener {

    private TetrisGrafiikka grafiikka;
    private ArrayList<Pala> pelipalat;
    private ArrayList<Palkki> palkit;
    private TiedostonKasittelija tiedostonkasittelija;
    private int liikkumisNopeus;
    private int pisteet;
    private int loppuPisteet;
    private int yleinenNopeus;
    private int kaynnissa = 0;
    private int paattynyt = 0;

    /**
     * Tetriksen, peli pääpeliluokan konstruktori
     */
    public Tetris() {
        super(150, null);
        this.tiedostonkasittelija = new TiedostonKasittelija("top10.txt");
        this.pisteet = 0;
        this.liikkumisNopeus = 10;
        this.yleinenNopeus = 50;
        addActionListener(this);

        this.pelipalat = new ArrayList<Pala>();
        this.palkit = new ArrayList<Palkki>();

        luoPeliAreena();
        lisaaPala();

    }
    
    /**
     * Asettaa vaikeustason
     * @param taso 
     */
    public void setVaikeustaso(int taso){
        this.yleinenNopeus = taso;
        super.setDelay(this.yleinenNopeus);
    }

    /**
     * Alustaa pelin
     */
    public void alustaPeli() {
        this.loppuPisteet = this.pisteet;
        
        this.liikkumisNopeus = 10;
        this.yleinenNopeus = 150;
        super.setDelay(this.yleinenNopeus);
        this.pelipalat = new ArrayList<Pala>();
        this.palkit = new ArrayList<Palkki>();

        luoPeliAreena();
        lisaaPala();
        this.pisteet = 0;
        super.restart();
    }
    
    /**
     * Luo pelikentän
     */
    public void luoPelipalat(){
            for (int i = 0; i < 12; i++) {
            for (int ii = 0; ii < 17; ii++) {
                this.pelipalat.add(new Pala(i * 40, ii * 40, "harmaa.png"));
            }
        }
    }

    /**
     * Jättää pelikenttään jäljelle vain kentän rajat
     */
    public void tuhoaOsaPelipaloista(){
        for (int i = 1; i < 11; i++) {
            for (int ii = 0; ii < 16; ii++) {
                Pala pala = new Pala(i * 40, ii * 40, "harmaa.png");
                for (int a = 0; a < this.pelipalat.size(); a++) {
                    if (pala.getX() == this.pelipalat.get(a).getX() && pala.getY() == this.pelipalat.get(a).getY()) {
                        this.pelipalat.remove(a);
                    }
                }
            }
        }
    }
    
    /**
     * Luo peliareenan, eli luo ensin kentän ja sitten poistaa osan paloista jättäen jäljelle vain ääriviivat
     */
    public void luoPeliAreena() {
        luoPelipalat();

        tuhoaOsaPelipaloista();
    }

    /**
     * Arpoo palkin värin
     * @return 
     */
    public String arvoVari() {
        Random r = new Random();
        int rand = r.nextInt(5);

        if (rand == 0) {
            return "pun.png";
        } else if (rand == 1) {
            return "kelt.png";
        } else if (rand == 2) {
            return "tummsin.png";
        } else if (rand == 3) {
            return "vaalsin.png";
        } else {
            return "vihr.png";
        }

    }

    /**
     * Arpoo palkin tyypin
     * @return 
     */
    public int arvoTyyppi() {
        Random r = new Random();
        return 1 + r.nextInt(6);
    }

    /**
     * Lisää palkin
     */
    public void lisaaPala() {
        this.palkit.add(new PeliPalkki(200, 0, arvoVari(), arvoTyyppi()));
    }

    /**
     * Palauttaa pelikentän Palat
     * @return 
     */
    public ArrayList<Pala> getPeliPalat() {
        return this.pelipalat;
    }

    /**
     * Palauttaa kaikki palkit
     * @return 
     */
    public ArrayList<Palkki> getPalkit() {
        return this.palkit;
    }

    /**
     * Asettaa pelin TetrisGrafiikan
     * @param grafiikka 
     */
    public void setGrafiikka(TetrisGrafiikka grafiikka) {
        this.grafiikka = grafiikka;
    }

    /**
     * Laukaistaan kun peli päättyy. Luodaan top-lista ja alustetaan peli
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void peliPaattyi() throws FileNotFoundException, IOException {
        for (int a = 0; a < this.palkit.size() - 1; a++) {
            ArrayList<Pala> palkkipalat1 = this.palkit.get(a).getPalat();
            for (int aa = 0; aa < palkkipalat1.size(); aa++) {
                if (palkkipalat1.get(aa).getY() <= 0) {
                    super.stop();
                    this.tiedostonkasittelija.viePisteet( this.pisteet);
                    this.grafiikka.setTopPisteet(this.tiedostonkasittelija.palautaPisteet());
                    this.grafiikka.repaint();
                    this.setPaattyi();
                    this.alustaPeli();
                }
            }
        }
    }

    /**
     * Tipauttaa kaikki tietyn rajan yläpuolella olevat Palat alas
     * @param y 
     */
    public void alasRivit(int y) {
        for (int i = 0; i < 2; i++) {
            for (int a = 0; a < this.palkit.size(); a++) {
                ArrayList<Pala> palkkipalat1 = this.palkit.get(a).getPalat();
                for (int aa = 0; aa < palkkipalat1.size(); aa++) {
                    if (palkkipalat1.get(aa).getY() < y) {
                        while (kykeneekoLiikkumaanAlas(palkkipalat1.get(aa))) {
                            palkkipalat1.get(aa).alas(40);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Hakee rivien y-koordinaatteja
     * @return 
     */
    public int[][] haeRiviKohdat(){
        int[][] riviY = new int[2][1000];
        int laskuri = 0;
        for (int i = 0; i < this.palkit.size(); i++) {
            ArrayList<Pala> palkkipalat1 = this.palkit.get(i).getPalat();
            for (int ii = 0; ii < palkkipalat1.size(); ii++) {
                riviY[0][laskuri] = palkkipalat1.get(ii).getY();
                for (int a = 0; a < this.palkit.size(); a++) {
                    ArrayList<Pala> palkkipalat2 = this.palkit.get(a).getPalat();
                    for (int aa = 0; aa < palkkipalat2.size(); aa++) {
                        if (palkkipalat1.get(ii).getY() == palkkipalat2.get(aa).getY()) {
                            riviY[1][laskuri]++;
                        }
                    }
                }
                laskuri++;
            }
        }
        return riviY;
    }

    /**
     * Ja jos samalla rivillä on kymmenen Palaa, ko. y-koordinaatti otetaan huomioon
     * @return 
     */
    public ArrayList<Integer> tarkistaRivi() {
        int[][] riviY = haeRiviKohdat();
        ArrayList<Integer> yyt = new ArrayList<Integer>();


        for (int i = 0; i < riviY[1].length; i++) {
            if (riviY[1][i] == 10) {
                for (int a = 0; a < this.palkit.size(); a++) {
                    ArrayList<Pala> palkkipalat1 = this.palkit.get(a).getPalat();
                    for (int aa = 0; aa < palkkipalat1.size(); aa++) {
                        if (palkkipalat1.get(aa).getY() == riviY[0][i]) {
                            palkkipalat1.remove(aa);
                        }
                    }
                }
                yyt.add(riviY[0][i]);
            }
        }
        return yyt;
    }

    /**
     * Tarkastelee, onko tietyissä koordinaateissa Palaa
     * @param x
     * @param y
     * @return 
     */
    public boolean onkoTassaPala(int x, int y) {
        boolean ret = false;
        for (int i = 0; i < this.pelipalat.size(); i++) {
            if (this.pelipalat.get(i).getX() == x && this.pelipalat.get(i).getY() == y) {
                ret = true;
            }
        }
        return ret;
    }
    
  /**
   * Tarkastelee, voiko palkki liikkua alaspäin
   * @param palat
   * @param itseMukana
   * @return 
   */  
  public boolean kykeneekoLiikkumaanAlasTarkistus(ArrayList<Pala> palat , int itseMukana){
      boolean ret=true;
         for (int i = 0; i < palat.size(); i++) {
            for (int ii = 0; ii < this.pelipalat.size(); ii++) {
                if (palat.get(i).getX() == this.pelipalat.get(ii).getX() && palat.get(i).getY() + 40 == this.pelipalat.get(ii).getY()) {
                    ret = false;
                }
            }

            for (int a = 0; a < this.palkit.size() - itseMukana; a++) {
                ArrayList<Pala> palkkipalat = this.palkit.get(a).getPalat();
                for (int aa = 0; aa < palkkipalat.size(); aa++) {
                    if (palat.get(i).getX() == palkkipalat.get(aa).getX() && palat.get(i).getY() + 40 == palkkipalat.get(aa).getY()) {
                        ret = false;
                    }
                }

            }
        }
         return ret;
  }  

  /**
   * Kykeneekö yksittäinen Pala liikkumaan alaspäin?
   * @param palkki
   * @return 
   */
  public boolean kykeneekoLiikkumaanAlas(Pala palkki) {
        ArrayList<Pala> palat = new ArrayList<Pala>();
        palat.add(palkki);

        boolean ret = true;
        
        ret = kykeneekoLiikkumaanAlasTarkistus(palat,0);

        return ret;
    }

  /**
   * Kykeneekö kokonainen palkki liikkumaan alaspäin?
   * @return 
   */
    public boolean kykeneekoLiikkumaanAlas() {
        ArrayList<Pala> palat = this.palkit.get(this.palkit.size() - 1).getPalat();
        boolean ret = true;

        ret = kykeneekoLiikkumaanAlasTarkistus(palat,1);

        return ret;
    }

/**
 * Tarkastelee, voiko palkki liikkua sivuttain
 * @return 
 */
    public boolean kykeneekoLiikkumaanSivuttain() {
        ArrayList<Pala> palat = this.palkit.get(this.palkit.size() - 1).getPalat();
        boolean ret = true;

        for (int i = 0; i < palat.size(); i++) {
            for (int ii = 0; ii < this.pelipalat.size(); ii++) {
                if (palat.get(i).osuukoPalaan(this.pelipalat.get(ii))) {
                    ret = false;
                }
            }

            for (int a = 0; a < this.palkit.size() - 1; a++) {
                ArrayList<Pala> palkkipalat = this.palkit.get(a).getPalat();
                for (int aa = 0; aa < palkkipalat.size(); aa++) {
                    if (palat.get(i).osuukoPalaan(palkkipalat.get(aa))) {
                        ret = false;
                    }
                }

            }
        }

        return ret;
    }

    /**
     * Tarkastelee, onko palkilla tilaa kääntyä
     * @return 
     */
    public boolean kykeneekoKaantymaan() {
        PeliPalkki palat = (PeliPalkki) this.palkit.get(this.palkit.size() - 1);
        boolean ret = true;

        for (int ii = 0; ii < this.pelipalat.size(); ii++) {
            if (palat.osuukoPalaan(this.pelipalat.get(ii))) {
                ret = false;
            }
        }

        for (int a = 0; a < this.palkit.size() - 1; a++) {
            ArrayList<Pala> palkkipalat = this.palkit.get(a).getPalat();
            for (int aa = 0; aa < palkkipalat.size(); aa++) {
                if (palat.osuukoPalaan(palkkipalat.get(aa))) {
                    ret = false;
                }
            }

        }
        return ret;
    }

    /**
     * Palauttaa this.kaynnissa:n
     * @return 
     */
    public int getKaynnissa() {
        return this.kaynnissa;
    }

    /**
     * Asettaa tetriksen pyörimään
     */
    public void setKaynnissa() {
        this.kaynnissa = 1;
        this.paattynyt = 0;
    }

    /**
     * Peli asetetaan päättyneeksi
     */
    public void setPaattyi() {
        this.kaynnissa = 0;
        this.paattynyt = 1;
    }

    /**
     * Peliluuppia. Liikutetaan palkkia alaspäin, ja tarvittaessa tuhotaan rivejä ja pudotellaan Paloja
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.kaynnissa == 1) {
            try {
                peliPaattyi();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            if (kykeneekoLiikkumaanAlas()) {
                this.palkit.get(this.palkit.size() - 1).liikuAlas(liikkumisNopeus);
            } else {
                while (true) {
                    ArrayList<Integer> yyt = tarkistaRivi();
                    if (yyt.size() == 0) {
                        break;
                    }

                    for (int i = 0; i < yyt.size(); i++) {
                        alasRivit(yyt.get(i));
                        this.pisteet += 1;


                    }
                }
                lisaaPala();
            }


            this.grafiikka.paivita();
        }
    }

    /**
     * Palauttaa this.pisteet
     * @return 
     */
    public int getPisteet() {
        return this.pisteet;
    }

    /**
     * Paluttaa edellisen kierroksen pisteet (eli lopulliset pisteet)
     * @return 
     */
    public int getLoppuPisteet() {
        return this.loppuPisteet;
    }

    /**
     * Onko peli päättynyt?
     * @return 
     */
    public int getPaattynyt() {
        return this.paattynyt;
    }
}
