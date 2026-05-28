package script;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class posisi {

    private JComponent component;

    public posisi(JComponent component) {

        this.component = component;
    }

    public void tengahHorizontal(JFrame frame) {

        int x =
            (frame.getWidth()
            - component.getWidth()) / 2;

        component.setLocation(
            x,
            component.getY()
        );
    }

    public void tengahVertical(JFrame frame) {

        int y =
            (frame.getHeight()
            - component.getHeight()) / 2;

        component.setLocation(
            component.getX(),
            y
        );
    }

    public void tengah(JFrame frame) {

        int x =
            (frame.getWidth()
            - component.getWidth()) / 2;

        int y =
            (frame.getHeight()
            - component.getHeight()) / 2;

        component.setLocation(x, y);
    }

    public void posisi(int x, int y) {

        component.setLocation(x, y);
    }
}