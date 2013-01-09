package tetrispeli.peli;

/**
 * Luokka yksittäisen neliskulmaiselle palalle, joista niin pelialue kuin pelipalkitkin koostuvat
 * @author matti
 */

public class Pala {

    private int x;
    private int y;
    private String kuva;
    
    /**
     * Palan konstruktori
     * @param x
     * @param y
     * @param kuva 
     */

    public Pala(int x, int y, String kuva) {
        this.x = x;
        this.y = y;
        this.kuva = kuva;
    }

    /**
     * Palauttaa this.kuva:n
     * @return 
     */
    public String getKuva() {
        return this.kuva;
    }

    /**
     * Palauttaa this.x:n
     * @return 
     */
    public int getX() {
        return this.x;
    }
    
/**
 * Palauttaa this.y:n
 * @return 
 */
    public int getY() {
        return this.y;
    }

    /**
     * Liikuttaa palaa. Oikeasti vain säätelee y-koordinaattia.
     * @param nopeus 
     */
    public void alas(int nopeus) {
        this.y += nopeus;
    }

    /**
     * Liikuttaa palaa vasemmalle. Säätelee siis x-koordinaattia
     */
    public void vasemmalle() {
        this.x -= 40;
    }

    /**
     * Liikuttaa palaa oikealle. Säätelee siis x-koordinaattia
     */
    public void oikealle() {
        this.x += 40;
    }

    /**
     * Tällä metodilla voidana tarkastella, osuuko Pala toiseen palaan.
     * @param pala
     * @return 
     */
    public boolean osuukoPalaan(Pala pala) {
        boolean ret = false;

        int al = -40+this.x;
        int bl = pala.getX();
        int ar = this.x+80;
        int br = pala.getX() + 40;

        int au = 10 + this.y;
        int bu = pala.getY();
        int ad = 10 + this.y + 40;
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
