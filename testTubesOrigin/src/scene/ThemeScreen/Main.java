package gamethemeselector;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Pakai Look and Feel sistem (opsional: bisa diganti Nimbus)
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ThemeSelectionFrame frame = new ThemeSelectionFrame();
            frame.setVisible(true);
        });
    }
}
