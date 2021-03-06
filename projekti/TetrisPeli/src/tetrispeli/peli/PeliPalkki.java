
package tetrispeli.peli;

import java.util.ArrayList;

/**
 * PeliPalkki perii luokan Palkki. PeliPalkki sisältää erityyppisten palkkien abstraktimmat muodot sekä metodit kääntämistä ja luomista varten.
 * @author matti
 */

public class PeliPalkki extends Palkki{
    
    /**
     * Pelipalkin tyyppi, eli muoto
     */
    private int tyyppi;
    /**
     * Pelipalkin asento
     */
    private int kaannos;
    
    /*
    private int[][] tyyppi1= { {0,0}, {0,1}, {0,2}, {0,3} };
    private int[][] tyyppi12= { {-1,0}, {0,0}, {1,0}, {2,0} };
    /*
    private int[][] tyyppi2= { {0,0}, {0,1}, {0,2}, {1,1} };
    private int[][] tyyppi22= { {-1,1}, {0,1}, {0,2}, {1,1} };
    private int[][] tyyppi23= { {0,0}, {0,1}, {0,2}, {-1,1} };
    private int[][] tyyppi24= { {-1,1}, {0,1}, {0,0}, {1,1} };
    
    /*
    private int[][] tyyppi3= { {1,0}, {1,1}, {0,1}, {0,2} };
    private int[][] tyyppi32= { {0,0}, {1,0}, {1,1}, {2,1} };
    /*
    private int[][] tyyppi4= { {0,0}, {0,1}, {1,1}, {1,0} };
    
/*
    private int[][] tyyppi6= { {0,1}, {1,1}, {1,0}, {2,0} };
    private int[][] tyyppi62= { {0,0}, {0,1}, {1,1}, {1,2} };
    
    /*
    private int[][] tyyppi7= { {0,0}, {1,0}, {1,1}, {1,2} };
    private int[][] tyyppi72 = { {0,0}, {1,0}, {2,0}, {2,1} };
    private int[][] tyyppi73= { {0,0}, {0,1}, {0,2}, {1,2} };
    private int[][] tyyppi74= { {0,0}, {1,0}, {2,0}, {0,1} };
    */
    
    /**
     * Palkin muoto ja kaikki sen asennot
     */
    private int[][][] t1 = {{ {0,0}, {0,1}, {0,2}, {0,3} },
                           { {-1,0}, {0,0}, {1,0}, {2,0} },
                           { {0,0}, {0,1}, {0,2}, {0,3} },
                           { {-1,0}, {0,0}, {1,0}, {2,0} }};
    /**
     * Palkin muoto ja kaikki sen asennot
     */
    private int[][][] t2 = {{ {0,0}, {0,1}, {0,2}, {1,1} }, 
                           { {-1,1}, {0,1}, {0,2}, {1,1} },
                           { {0,0}, {0,1}, {0,2}, {-1,1} },
                           { {-1,1}, {0,1}, {0,0}, {1,1} } };
    /**
     * Palkin muoto ja kaikki sen asennot
     */
    private int[][][] t3 = {{ {1,0}, {1,1}, {0,1}, {0,2} }, 
                           { {0,0}, {1,0}, {1,1}, {2,1} },
                            { {1,0}, {1,1}, {0,1}, {0,2} }, 
                           { {0,0}, {1,0}, {1,1}, {2,1} }};
    /**
     * Palkin muoto ja kaikki sen asennot
     */
    private int[][][] t4 = {{ {0,0}, {0,1}, {1,1}, {1,0} },
                             { {0,0}, {0,1}, {1,1}, {1,0} },
                             { {0,0}, {0,1}, {1,1}, {1,0} },
                            { {0,0}, {0,1}, {1,1}, {1,0} }};
    /**
     * Palkin muoto ja kaikki sen asennot
     */
    private int[][][] t6 ={ { {0,1}, {1,1}, {1,0}, {2,0} },
                            { {0,0}, {0,1}, {1,1}, {1,2} }, 
                              { {0,1}, {1,1}, {1,0}, {2,0} },
                            { {0,0}, {0,1}, {1,1}, {1,2} },};
    /**
     * Palkin muoto ja kaikki sen asennot
     */
    private int[][][] t7 = { { {0,0}, {1,0}, {1,1}, {1,2} },
                             { {0,0}, {1,0}, {2,0}, {2,1} },
                             { {0,0}, {0,1}, {0,2}, {1,2} },
                             { {0,0}, {1,0}, {2,0}, {0,1} } };

    /**
     * PeliPalkin konstruktori
     * @param x
     * @param y
     * @param kuva
     * @param tyyppi 
     */
    public PeliPalkki(int x, int y, String kuva, int tyyppi){
        super(x, y, kuva);      
        this.tyyppi=tyyppi;
        this.kaannos=0;
        luoPalkki(this.tyyppi);
    }
    
    /**
     * Palauttaa this.tyyppi:n
     * @return 
     */
    public int getTyyppi(){
        return this.tyyppi;
    }
    
    /**
     * Luo palkin, eli lisää ArrayListiin neljä palaa sovituin koordinaatein.
     * @param tyyppi 
     */
    public void luoPalkki(int tyyppi){
        if(tyyppi==1){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t1[0][i][0]*super.palakoko, super.getY()+this.t1[0][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==2){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t2[0][i][0]*super.palakoko, super.getY()+this.t2[0][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==3){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t3[0][i][0]*super.palakoko, super.getY()+this.t3[0][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==4){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t4[0][i][0]*super.palakoko, super.getY()+this.t4[0][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==5){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t6[0][i][0]*super.palakoko, super.getY()+this.t6[0][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==6){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t7[0][i][0]*super.palakoko, super.getY()+this.t7[0][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
    }
 
    /**
     * Ylikirjoittaa Palkin kaanna-metodin. Käytetään, kun halutaan kääntää palkki ja asettaa Palat uuteen järjestykseen.
     */
    @Override
    public void kaanna(){
        this.kaannos++;
        if(this.kaannos==4){
            this.kaannos=0;
        }
        super.poistaPalat();
        
        if(tyyppi==1){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t1[this.kaannos][i][0]*super.palakoko, super.getY()+this.t1[this.kaannos][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==2){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t2[this.kaannos][i][0]*super.palakoko, super.getY()+this.t2[this.kaannos][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==3){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t3[this.kaannos][i][0]*super.palakoko, super.getY()+this.t3[this.kaannos][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==4){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t4[this.kaannos][i][0]*super.palakoko, super.getY()+this.t4[this.kaannos][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==5){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t6[this.kaannos][i][0]*super.palakoko, super.getY()+this.t6[this.kaannos][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==6){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.t7[this.kaannos][i][0]*super.palakoko, super.getY()+this.t7[this.kaannos][i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
    }
    
    /**
     * Tällä metodilla voidaan tarkastella, voiko kokonainen palkki kääntyä
     * @param pala
     * @return 
     */
    public boolean osuukoPalaan(Pala pala) {
        boolean ret = false;

        int al = -40+super.getX();
        int bl = pala.getX();
        int ar = super.getX()+40*4;
        int br = pala.getX() + 40;

        int au = super.getY();
        int bu = pala.getY();
        int ad = super.getY() + 40*4;
        int bd = pala.getY() + 40;

        if (al < (br)) {

            if ((ar) > bl) {
                if (au < (bd)) {

                    if ((ad) > bu) {
                        ret = true;
                    }

                }

            }

        }

        return ret;
    }
}

