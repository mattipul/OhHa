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

    public Tetris() {
        super(10, null);

        this.liikkumisNopeus = 10;

        addActionListener(this);

        this.pelipalat = new ArrayList<Pala>();
        this.palkit = new ArrayList<Palkki>();

        luoPeliAreena();
        lisaaPala();
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
    
    public String arvoVari(){
        Random r = new Random();
        int rand = r.nextInt(5);
        
        if(rand==0){
            return "pun.png";
        }
        else if(rand==1){
            return "kelt.png";
        }
        else if(rand==2){
            return "tummsin.png";
        }
        else if(rand==3){
            return "vaalsin.png";
        }
        else{
            return "vihr.png";
        }
        
    }
    
    public int arvoTyyppi(){
        Random r = new Random();
        return 1+r.nextInt(7);
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

    public boolean onkoTassaPala(int x, int y) {
        boolean ret = false;
        for (int i = 0; i < this.pelipalat.size(); i++) {
            if (this.pelipalat.get(i).getX() == x && this.pelipalat.get(i).getY() == y) {
                ret = true;
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
            
             for (int a = 0; a < this.palkit.size()-1; a++) {
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (kykeneekoLiikkumaanAlas()) {
            this.palkit.get(this.palkit.size() - 1).liikuAlas(liikkumisNopeus);
        } else {
            lisaaPala();
        }

        this.grafiikka.paivita();
    }
}
