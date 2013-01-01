package tetrispeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import tetrispeli.gui.TetrisGrafiikka;

public class Tetris extends Timer implements ActionListener {

    private TetrisGrafiikka grafiikka;
    private ArrayList<Pala> pelipalat;
    private ArrayList<Palkki> palkit;
    private int liikkumisNopeus;
    private int pisteet;
    private int loppuPisteet;
    private int yleinenNopeus;
    private int kaynnissa=0;
    private int paattynyt=0;

    public Tetris() {      
        super(10, null);
        this.pisteet=0;
        this.liikkumisNopeus = 10;
        this.yleinenNopeus = 10;
        addActionListener(this);

        this.pelipalat = new ArrayList<Pala>();
        this.palkit = new ArrayList<Palkki>();

        luoPeliAreena();
        lisaaPala();

    }
    
    public void alustaPeli(){
        this.loppuPisteet=this.pisteet;
        this.pisteet=0;
        this.liikkumisNopeus = 10;
        this.yleinenNopeus = 10;
        super.setDelay(this.yleinenNopeus);
        this.pelipalat = new ArrayList<Pala>();
        this.palkit = new ArrayList<Palkki>();
        
        luoPeliAreena();
        lisaaPala();
        super.restart();
    }

    public void luoPeliAreena() {
        for (int i = 0; i < 12; i++) {
            for (int ii = 0; ii < 17; ii++) {
                this.pelipalat.add(new Pala(i * 40, ii * 40, "harmaa.png"));
            }
        }

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

    public int arvoTyyppi() {
        Random r = new Random();
        return 1 + r.nextInt(6);
    }

    public void lisaaPala() {
        this.palkit.add(new PeliPalkki(200, 0, arvoVari(), arvoTyyppi()));
    }

    public ArrayList<Pala> getPeliPalat() {
        return this.pelipalat;
    }

    public ArrayList<Palkki> getPalkit() {
        return this.palkit;
    }

    public void setGrafiikka(TetrisGrafiikka grafiikka) {
        this.grafiikka = grafiikka;
    }
    
    public void peliPaattyi(){
        for (int a = 0; a< this.palkit.size()-1; a++) {
                    ArrayList<Pala> palkkipalat1 = this.palkit.get(a).getPalat();
                    for (int aa = 0; aa < palkkipalat1.size(); aa++) {
                        if(palkkipalat1.get(aa).getY()<=0){
                            super.stop();
                            this.setPaattyi();
                            this.alustaPeli();
                        }
                    }
        }
    }

    public void alasRivit(int y){
        for(int i=0; i<2; i++){
                for (int a = 0; a< this.palkit.size(); a++) {
                    ArrayList<Pala> palkkipalat1 = this.palkit.get(a).getPalat();
                    for (int aa = 0; aa < palkkipalat1.size(); aa++) {
                        if(palkkipalat1.get(aa).getY()<y){
                         while(kykeneekoLiikkumaanAlas(palkkipalat1.get(aa))){ 
                            palkkipalat1.get(aa).alas(40);
                        }
                        }
                    }
                }
        }
    }
    
    public ArrayList<Integer> tarkistaRivi() {
        int[] riviY = new int[1000];
        int[] y= new int[1000];
        ArrayList<Integer> yyt = new ArrayList<Integer>();
        int laskuri=0;
        for (int i = 0; i < this.palkit.size(); i++) {
            ArrayList<Pala> palkkipalat1 = this.palkit.get(i).getPalat();         
            for (int ii = 0; ii < palkkipalat1.size(); ii++) {  
                y[laskuri]=palkkipalat1.get(ii).getY();
                for (int a = 0; a < this.palkit.size(); a++) {
                    ArrayList<Pala> palkkipalat2 = this.palkit.get(a).getPalat();
                    for (int aa = 0; aa < palkkipalat2.size(); aa++) {
                        if( palkkipalat1.get(ii).getY() == palkkipalat2.get(aa).getY()){
                            riviY[laskuri]++;
                        }
                    }
                }
                laskuri++;
            }
        }
        
        for(int i=0; i<riviY.length; i++){
            if(riviY[i]==10){
                for (int a = 0; a< this.palkit.size(); a++) {
                    ArrayList<Pala> palkkipalat1 = this.palkit.get(a).getPalat();
                    for (int aa = 0; aa < palkkipalat1.size(); aa++) {
                        if( palkkipalat1.get(aa).getY()== y[i]){
                            palkkipalat1.remove(aa);                          
                        }
                    }
                }    
            yyt.add(y[i]);
        }
    }
        return yyt;
    }

    public boolean onkoTassaPala(int x, int y) {
        boolean ret = false;
        for (int i = 0; i < this.pelipalat.size(); i++) {
            if (this.pelipalat.get(i).getX() == x && this.pelipalat.get(i).getY() == y) {
                ret = true;
            }
        }
        return ret;
    }

     public boolean kykeneekoLiikkumaanAlas(Pala palkki) {
        ArrayList<Pala> palat = new ArrayList<Pala>();
        palat.add(palkki);

        boolean ret = true;

        for (int i = 0; i < palat.size(); i++) {
            for (int ii = 0; ii < this.pelipalat.size(); ii++) {
                if (palat.get(i).getX() == this.pelipalat.get(ii).getX() && palat.get(i).getY() + 40 == this.pelipalat.get(ii).getY()) {
                    ret = false;
                }
            }

            for (int a = 0; a < this.palkit.size(); a++) {
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
    
    public boolean kykeneekoLiikkumaanAlas() {
        ArrayList<Pala> palat = this.palkit.get(this.palkit.size() - 1).getPalat();
        boolean ret = true;

        for (int i = 0; i < palat.size(); i++) {
            for (int ii = 0; ii < this.pelipalat.size(); ii++) {
                if (palat.get(i).getX() == this.pelipalat.get(ii).getX() && palat.get(i).getY() + 40 == this.pelipalat.get(ii).getY()) {
                    ret = false;
                }
            }

            for (int a = 0; a < this.palkit.size()-1; a++) {
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

        
    public int getKaynnissa(){
        return this.kaynnissa;
    }
    
    public void setKaynnissa(){
        this.kaynnissa=1;
        this.paattynyt=0;
    }
    
    public void setPaattyi(){
        this.kaynnissa=0;
        this.paattynyt=1;
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {

        if(this.kaynnissa==1){
        peliPaattyi();
        if (kykeneekoLiikkumaanAlas()) {
            this.palkit.get(this.palkit.size() - 1).liikuAlas(liikkumisNopeus);
        } else {
            while(true){
            ArrayList<Integer> yyt = tarkistaRivi(); 
            if(yyt.size()==0){
                break;
            }

            for(int i=0; i<yyt.size(); i++){
            alasRivit(yyt.get(i));     
            this.pisteet+=1;
            
            
            }
            }
            lisaaPala();
    }
        
        
        this.grafiikka.paivita();
        }
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    
    public int getLoppuPisteet(){
        return this.loppuPisteet;
    }
    
    public int getPaattynyt(){
        return this.paattynyt;
    }
}
