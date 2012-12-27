package tetrispeli.peli;

public class Pala {

    private int x;
    private int y;
    private String kuva;

    public Pala(int x, int y, String kuva) {
        this.x = x;
        this.y = y;
        this.kuva = kuva;
    }

    public String getKuva() {
        return this.kuva;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void alas(int nopeus) {
        this.y += nopeus;
    }

    public void vasemmalle() {
        this.x -= 40;
    }

    public void oikealle() {
        this.x += 40;
    }
    
    public void setKuva(){
        this.kuva="harmaa.png";
    }

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
