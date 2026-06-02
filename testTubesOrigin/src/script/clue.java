
package script;

public class clue {
    
    private String nama;
    private String deskripsi;
    private boolean benar;
    private Saksi saksi;
    private String namaSaksi;
    private int poin;
    
    public clue(String nama, String deskripsi, boolean benar, Saksi saksi, String namaSaksi, int poin) {

        this.nama = nama;
        this.deskripsi = deskripsi;
        this.benar = benar;
        this.saksi = saksi;
        this.namaSaksi = namaSaksi;
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

    public Saksi getSaksi() {
        return saksi;
    }

    public void setSaksi(Saksi saksi) {
        this.saksi = saksi;
    }

    public String getNamaSaksi() {
        return namaSaksi;
    }

    public void setNamaSaksi(String namaSaksi) {
        this.namaSaksi = namaSaksi;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }
        


}