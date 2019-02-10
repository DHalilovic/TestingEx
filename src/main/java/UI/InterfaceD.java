package UI;

import javax.swing.*;
import java.awt.*;

public class InterfaceD extends JFrame {

    protected JFrame frame;

    public InterfaceD() {
        // Set initial size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(
                (int) ( 4 * screenSize.getHeight() / 5 ),
                (int) ( 2 * screenSize.getWidth() / 3 )
        );
        this.setLocation(0, 0);
    }


}
