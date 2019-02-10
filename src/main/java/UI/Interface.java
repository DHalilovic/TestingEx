package UI;

import javax.swing.JFrame;

public abstract class Interface {

    protected JFrame frame;

    public Interface() {
        frame = new JFrame("Graphical User Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
