package tetrispeli.peli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TiedostonKasittelija {

    private String tiedosto;

    public TiedostonKasittelija(String tiedosto) {
        this.tiedosto = tiedosto;
    }

    public String[] palautaPisteet() throws FileNotFoundException {
        String[] pisteet = new String[10];

        Scanner lukija = new Scanner(new File(this.tiedosto));
        int laskuri = 0;
        while (lukija.hasNext()) {
            pisteet[laskuri] = lukija.nextLine();
            laskuri++;
        }

        return pisteet;
    }

    public void viePisteet(String pisteet) throws IOException {
        FileWriter fstream = new FileWriter(this.tiedosto);
        BufferedWriter out = new BufferedWriter(fstream);
        
        out.write(pisteet);
        
        out.close();
    }
}
