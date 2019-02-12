package UI;

import Database.*;

import javax.swing.JFrame;

public abstract class Interface {

    protected JFrame frame;
    protected Database db;

    public Interface() {
        frame = new JFrame("Graphical User Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
