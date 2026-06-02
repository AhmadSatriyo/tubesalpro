package gamethemeselector;

import javax.swing.ImageIcon;

/**
 * Model data untuk setiap tema game.
 * Tambahkan properti lain sesuai kebutuhan (warna, musik, dll).
 */
public class GameTheme {
    
    private String name;        // Nama tema yang tampil di UI
    private String description; // Deskripsi singkat tema
    private ImageIcon image;    // Gambar preview tema
    private String themeId;     // ID unik untuk logika game
    
    public GameTheme(String themeId, String name, String description) {
        this.themeId = themeId;
        this.name = name;
        this.description = description;
        this.image = null; // Set image dari luar
    }
    
    public GameTheme(String themeId, String name, String description, ImageIcon image) {
        this.themeId = themeId;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    // ==================== GETTER & SETTER ====================
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public ImageIcon getImage() { return image; }
    public void setImage(ImageIcon image) { this.image = image; }
    
    public String getThemeId() { return themeId; }
    public void setThemeId(String themeId) { this.themeId = themeId; }
    
    @Override
    public String toString() {
        return "GameTheme{name='" + name + "', themeId='" + themeId + "'}";
    }
}
