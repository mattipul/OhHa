
package tetrispeli.peli;

import java.util.ArrayList;

/**
 * PeliPalkin ylempi luokka. Sisältää metodeita, joita tarvitaan palkin liikuttelussa ja yksittäisten palojen manipuloinnissa.
 * @author matti
 */

public abstract class Palkki {
    
    /**
     * Palkin x
     */
    private int x;
    /**
     * PAlkin y
     */
    private int y;
    /**
     * Palkin väri, eli siihen liitettävä kuva
     */
    private String kuva;
    /**
     * Sisältää Palat joista palkki koostuu
     */
    private ArrayList<Pala> palat;
    /**
     * Tarkistamiseen käytettäviä paloja voidaan lisätä tähän listaan
     */
    private ArrayList<Pala> tarkistuspalat;
    /**
     * Ilmoittaa Palan koon koordinaatistossa
     */
    public int palakoko=40;
    /**
     * Ilmoittaa, voiko palkki liikkua sivuttain
     */
    private boolean liikkuuSivuttain=true;
    /**
     * Ilmoittaa, voiko palkki liikkua alaspäin
     */
    private boolean liikkuuAlas=true;
    
    /**
     * Abstraktin luokan Palkki konstruktori
     * @param x
     * @param y
     * @param kuva 
     */
    public Palkki(int x, int y, String kuva){
        this.x=x;
        this.y=y;
        this.kuva=kuva;
        this.palat=new ArrayList<Pala>();
    }
    
/**
 * Ylikirjoitetaan alemmassa luokassa
 */
    public void kaanna(){
        
    }
    
    /**
     * Poistaa kaikki Palat ArrayListista.
     */
    public void poistaPalat(){
        this.palat=new ArrayList<Pala>();
    }

    /**
     * Lisää palan ArraListiin
     * @param pala 
     */
    public void lisaaPala(Pala pala){
        this.palat.add(pala);
    }
    
    /**
     * Palauttaa Paloja täynnä olevan ArrayListin
     * @return 
     */
    public ArrayList<Pala> getPalat(){
        return this.palat;
    }
    
    /**
     * Liikuttaa koko palkkia alaspäin
     * @param nopeus 
     */
    public void liikuAlas(int nopeus){
        this.y+=nopeus;
        for(int i=0; i<this.palat.size(); i++){
            this.palat.get(i).alas(nopeus);
        }
    }
    
    /**
     * Liikuttaa koko palkkia vasemmalle
     */
    public void liikuVasemmalle(){
        this.x-=40;
        for(int i=0; i<this.palat.size(); i++){
            this.palat.get(i).vasemmalle();
        }
    }
    
    
    /**
     * Liikuttaa koko palkkia oikealle
     */
    public void liikuOikealle(){
        this.x+=40;
        for(int i=0; i<this.palat.size(); i++){
            this.palat.get(i).oikealle();
        }
    }
    
    /**
     * Palauttaa this.x:n
     * @return 
     */
    public int getX(){
        return this.x;
    };
    
    /**
     * Palauttaa this.y:n.
     * @return 
     */
    public int getY(){
        return this.y;
    };
    
    /**
     * Käytetään, kun tarkastellaan, voiko palkki liikkua sivuttain
     * @return 
     */
    public boolean liikuukoSivuttain(){
        return this.liikkuuSivuttain;
    }
    
    /**
     * Käytetään kun halutaan tarkastella, voiko palkki liikkua alaspäin
     * @return 
     */
    public boolean liikuukoAlas(){
        return this.liikkuuAlas;
    }
    
    /**
     * Asettaa palkin (alaspäin) liikkumiskyvyttömäksi
     */
    public void alasLiikkumattomaksi(){
        this.liikkuuAlas=false;
    }
    
    /**
     * Tällä metodilla voidaan asettaa this.liikkuuSivuutain epätodeksi. Käytetään kun palkki kohtaa esteen sivuttaissuunnassa.
     */
    public void sivulleLiikkumattomaksi(){
        this.liikkuuSivuttain=false;
    }
    
    /**
     * Voidaan asettaa palkki taas liikkuvaksi
     */
        public void alasLiikkuvaksi(){
        this.liikkuuAlas=true;
    }
    
        /**
         * Asettaa palkin taas liikkuvaksi, kun kyse on sivuttaissuuntaisesta liikkeestä
         */
    public void sivulleLiikkuvaksi(){
        this.liikkuuSivuttain=true;
    }
    
    /**
     * Palauttaa this.kuva:n
     * @return 
     */
    public String getKuva(){
        return this.kuva;
    };
    
    
    
}
