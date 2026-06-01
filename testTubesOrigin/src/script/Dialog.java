package script;

public class Dialog {
    private String nama;
    private String teks;

    // Constructor untuk memaketkan data dialog
    public Dialog(String nama, String teks) {
        this.nama = nama;
        this.teks = teks;
    }

    // Getter (Gak usah pakai setter gak apa-apa biar cepet)
    public String getNama() { return nama; }
    public String getTeks() { return teks; }
}