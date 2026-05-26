
package script;

public class tersangkaDanSaksi extends character {
    
    private String sifat;
    private String petunjuk;
    private String status;
    private String peran;
    private boolean pembunuh;
    
    public tersangkaDanSaksi(String path, String nama, String sifat, String petunjuk, String status, String peran, boolean pembunuh) {
        
        super(path, nama);
        
        this.petunjuk = petunjuk;
        this.sifat = sifat;
        this.status = status;
        this.peran = peran;
        this.pembunuh = pembunuh;
    }
    
    public String getPetunjuk() {
        return petunjuk;
    }
    
    public String getSfiat() {
        return sifat;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getPeran() {
        return peran;
    }
    
    public boolean getPembunuh() {
        return pembunuh;
    }
    
    public void setPetunjuk(String petunjuk) {
        this.petunjuk = petunjuk;
    }
    
    public void setSfiat(String sifat) {
        this.sifat = sifat;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setPeran(String peran) {
        this.peran = peran;
    }
    
    public void setPembunuh(boolean pembunuh) {
        this.pembunuh = pembunuh;
    }
    
}
