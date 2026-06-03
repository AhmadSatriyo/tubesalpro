
package script;

public class clue {
    
    private String nama;
    private String deskripsi;
    private String prioritas;
    private String tipe;
    private boolean benar;
    private Saksi saksi;
    private Tersangka tersangka;
    private String namaSaksi;
    private int poin;
        
    public clue(String nama, String deskripsi, String tipe, String prioritas, boolean benar, Saksi saksi, String namaSaksi, int poin) {

        this.nama = nama;
        this.deskripsi = deskripsi;
        this.tipe = tipe;
        this.prioritas = prioritas;
        this.benar = benar;
        this.saksi = saksi;
        this.namaSaksi = namaSaksi;
        this.poin = poin;
    }
    
    public clue(String nama, String deskripsi, String tipe, String prioritas, boolean benar, Tersangka tersangka, String namaSaksi, int poin) {

        this.nama = nama;
        this.deskripsi = deskripsi;
        this.tipe = tipe;
        this.prioritas = prioritas;
        this.benar = benar;
        this.tersangka = tersangka;
        this.namaSaksi = namaSaksi;
        this.poin = poin;
    }
    
    
    
    public String getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(String prioritas) {
        this.prioritas = prioritas;
    }
    
    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
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