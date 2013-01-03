package tetrispeli.peli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TiedostonKasittelija {

    private String tiedosto;

    public TiedostonKasittelija(String tiedosto) {
        this.tiedosto = tiedosto;
    }

    public String[] palautaPisteet() throws FileNotFoundException {
        String[] pisteet = new String[11];

        Scanner lukija = new Scanner(new File(this.tiedosto));
        int laskuri = 0;
        while (lukija.hasNext()) {
            pisteet[laskuri] = lukija.nextLine();
            laskuri++;
        }

        return pisteet;
    }
    
    public String jarjestaPisteet(int piste) throws FileNotFoundException{
        String[] pisteet = this.palautaPisteet();
        pisteet[10]=""+piste;
        int[] pisteetInt=new int[11];
        String ret="";

        for(int i=0; i<pisteet.length; i++){
            pisteetInt[i]=Integer.parseInt( pisteet[i] );
        }
        
        Arrays.sort( pisteetInt );
        
        
        
        for(int i=10; i>0; i--){
            System.out.println(pisteetInt[i]);
            ret=ret+pisteetInt[i]+"\n";
        }

        return ret;
    }

    public void viePisteet(int piste) throws IOException {
        String pisteet = jarjestaPisteet(piste);
        FileWriter fstream = new FileWriter(this.tiedosto);
        fstream.write( pisteet );       
        fstream.close();
    }
}
