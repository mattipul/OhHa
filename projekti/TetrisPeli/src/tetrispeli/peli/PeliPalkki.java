
package tetrispeli.peli;

import java.util.ArrayList;

public class PeliPalkki extends Palkki{
    
    private int tyyppi;
    
    private int[][] tyyppi1= { {0,0}, {0,1}, {0,2}, {0,3} };
    private int[][] tyyppi2= { {0,0}, {0,1}, {0,2}, {1,1} };
    private int[][] tyyppi3= { {1,0}, {1,1}, {0,1}, {0,2} };
    private int[][] tyyppi4= { {0,0}, {0,1}, {1,1}, {1,0} };
    private int[][] tyyppi5= { {0,0}, {0,1}, {1,1}, {1,0} };
    private int[][] tyyppi6= { {0,0}, {1,0}, {1,1}, {2,1} };
    private int[][] tyyppi7= { {0,0}, {1,0}, {1,1}, {1,2} };

    public PeliPalkki(int x, int y, String kuva, int tyyppi){
        super(x, y, kuva);      
        this.tyyppi=tyyppi;
        luoPalkki(this.tyyppi);
    }
    
    public int getTyyppi(){
        return this.tyyppi;
    }
    
    public void luoPalkki(int tyyppi){
        if(tyyppi==1){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.tyyppi1[i][0]*super.palakoko, super.getY()+this.tyyppi1[i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==2){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.tyyppi2[i][0]*super.palakoko, super.getY()+this.tyyppi2[i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==3){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.tyyppi3[i][0]*super.palakoko, super.getY()+this.tyyppi3[i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==4){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.tyyppi4[i][0]*super.palakoko, super.getY()+this.tyyppi4[i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==5){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.tyyppi5[i][0]*super.palakoko, super.getY()+this.tyyppi5[i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==6){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.tyyppi6[i][0]*super.palakoko, super.getY()+this.tyyppi6[i][1]*super.palakoko, super.getKuva() ) );
            }
        }
        
        if(tyyppi==7){
            for(int i=0; i<4; i++){
                super.lisaaPala( new Pala( super.getX()+this.tyyppi7[i][0]*super.palakoko, super.getY()+this.tyyppi7[i][1]*super.palakoko, super.getKuva() ) );
            }
        }
    }
 
    public void kaanna(){
        
    }
    
}

