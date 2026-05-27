
package script;

public class detektif extends character {
    
    private String namaPlayer;
    
    public detektif(String path, String nama, String namaPlayer) {
        
        super(path, nama);
        this.namaPlayer = namaPlayer;
    }
    
    public String getNamaPlayer() {
        return namaPlayer;
    }
    
    public void setNamaPlayer(String namaPlayer) {
        this.namaPlayer = namaPlayer;
    }
    
}
