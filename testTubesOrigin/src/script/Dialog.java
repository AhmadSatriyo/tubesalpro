package script;

public class Dialog {
    private String nama;
    private String teks;

    public Dialog(String nama, String teks) {
        this.nama = nama;
        this.teks = teks;
    }

    public String getNama() { return nama; }
    public String getTeks() { return teks; }
}