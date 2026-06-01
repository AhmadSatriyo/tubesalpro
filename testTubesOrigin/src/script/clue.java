
package script;

public class clue {
    
    private String nama;
    private String deskripsi;
    private boolean benar;
    private Character pemberi;
    private int poin;

    public clue(String nama, String deskripsi, boolean benar, Character pemberi, int poin) {

        this.nama = nama;
        this.deskripsi = deskripsi;
        this.benar = benar;
        this.pemberi = pemberi;
        this.poin = poin;
    }
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public boolean isBenar() {
        return benar;
    }

    public void setBenar(boolean benar) {
        this.benar = benar;
    }

    public Character getPemberi() {
        return pemberi;
    }

    public void setPemberi(Character pemberi) {
        this.pemberi = pemberi;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }


}