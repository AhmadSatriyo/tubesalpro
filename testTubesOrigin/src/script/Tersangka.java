
package script;

public class Tersangka extends character {

    public String getSifat() {
        return sifat;
    }

    public void setSifat(String sifat) {
        this.sifat = sifat;
    }

    public boolean isPembunuh() {
        return pembunuh;
    }

    public void setPembunuh(boolean pembunuh) {
        this.pembunuh = pembunuh;
    }

    private String sifat;
    private boolean pembunuh;

    public Tersangka(String path, String nama, String sifat) {

        super(path, nama);

        this.sifat = sifat;
        this.pembunuh = false;
    }

}
