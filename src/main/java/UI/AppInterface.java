package UI;

import Database.AppDatabase;

import javax.swing.*;
import java.awt.*;

public class AppInterface extends Interface {

    protected JPanel[] panels;
    protected JTextArea textArea;
    protected AppDatabase db;

    public AppInterface(){
        super();

        db = new AppDatabase();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (  screenSize.getHeight()  ) ;
        int width = (int) ( 4.5 * screenSize.getWidth() / 5 ) ;

        frame.setSize(width, height);
        frame.setLocation(0, 0);

        frame.setLayout(new GridLayout(2,1));

        panels = new JPanel[2];

        setPanel();

        setTextArea();

        frame.setVisible(true);
    }

    private void setPanel() {
        // textfield for 'name' attribute:
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField(20);
        nameLabel.setLabelFor(nameTextField);

        // checkbox for 'good' attribute:
        JLabel goodLabel = new JLabel("Good?:");
        JCheckBox goodCheckBox = new JCheckBox();
        goodLabel.setLabelFor(goodCheckBox);

        // textfield for 'length' attribute:
        JLabel lengthLabel = new JLabel("Length:");
        JTextField lengthTextField = new JTextField(20);
        lengthLabel.setLabelFor(lengthTextField);

        // Create buttons:
        JButton addBtn = new JButton("Add record");
        JButton deleteBtn = new JButton("Delete record");
        JButton findBtn = new JButton("Find record");

        // Add success label:
        JLabel successLabel = new JLabel("Result: ");

        // Add all attributes to panels:
        panels[0] = new JPanel();
        panels[0].setLayout(new FlowLayout());

        String[] operators = new String[] {"==", "!=", "<",
                "<=", ">", ">="};

        panels[0].add(nameLabel);
        panels[0].add(nameTextField);

        panels[0].add(goodLabel);
        panels[0].add(goodCheckBox);

        panels[0].add(lengthLabel);
        panels[0].add(lengthTextField);

        panels[0].add(addBtn);
        panels[0].add(deleteBtn);
        panels[0].add(findBtn);
        panels[0].add(successLabel);

        frame.getContentPane().add(panels[0]);
    }

    private void setTextArea() {
        panels[1] = new JPanel();
        panels[1].setPreferredSize(new Dimension(200, 250));
        textArea = new JTextArea(10, 100);

        JScrollPane vertical = new JScrollPane(textArea);
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panels[1].add(vertical);

        frame.getContentPane().add(panels[1]);
    }


}
