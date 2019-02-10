package UI;

import javax.swing.*;
import java.awt.*;

public class InterfaceD {

    protected JFrame frame;

    public InterfaceD() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(
                (int) ( 4 * screenSize.getHeight() / 5 ),
                (int) ( 2 * screenSize.getWidth() / 3 )
        );
        frame.setLocation(0, 0);


    }


}
