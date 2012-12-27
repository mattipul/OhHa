
package tetrispeli.peli;

import java.util.ArrayList;

public abstract class Palkki {
    
    private int x;
    private int y;
    private String kuva;
    private ArrayList<Pala> palat;
    private ArrayList<Pala> tarkistuspalat;
    public int palakoko=40;
    private boolean liikkuuSivuttain=true;
    private boolean liikkuuAlas=true;
    
    public Palkki(int x, int y, String kuva){
        this.x=x;
        this.y=y;
        this.kuva=kuva;
        this.palat=new ArrayList<Pala>();
    }
    

    public void kaanna(){
        
    }
    
    public void poistaPalat(){
        this.palat=new ArrayList<Pala>();
    }

    public void lisaaPala(Pala pala){
        this.palat.add(pala);
    }
    
    public ArrayList<Pala> getPalat(){
        return this.palat;
    }
    
    public void liikuAlas(int nopeus){
        this.y+=nopeus;
        for(int i=0; i<this.palat.size(); i++){
            this.palat.get(i).alas(nopeus);
        }
    }
    
    public void liikuVasemmalle(){
        this.x-=40;
        for(int i=0; i<this.palat.size(); i++){
            this.palat.get(i).vasemmalle();
        }
    }
    
    public void liikuOikealle(){
        this.x+=40;
        for(int i=0; i<this.palat.size(); i++){
            this.palat.get(i).oikealle();
        }
    }
    
    public int getX(){
        return this.x;
    };
    
    public int getY(){
        return this.y;
    };
    
    public boolean liikuukoSivuttain(){
        return this.liikkuuSivuttain;
    }
    
    public boolean liikuukoAlas(){
        return this.liikkuuAlas;
    }
    
    public void alasLiikkumattomaksi(){
        this.liikkuuAlas=false;
    }
    
    public void sivulleLiikkumattomaksi(){
        this.liikkuuSivuttain=false;
    }
    
        public void alasLiikkuvaksi(){
        this.liikkuuAlas=true;
    }
    
    public void sivulleLiikkuvaksi(){
        this.liikkuuSivuttain=true;
    }
    
    public String getKuva(){
        return this.kuva;
    };
    
    
    
}
