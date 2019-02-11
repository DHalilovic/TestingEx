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

        frame.setLayout(new GridLayout(4,1));

        panels = new JPanel[4];

        setAddRecordPanel();
        setDeleteRecordsPanel();
        setFilterRecordsPanel();

        setTextArea();

        frame.setVisible(true);
    }

    private void setAddRecordPanel() {
        setPanel(0, "Add record", true);
    }

    private void setDeleteRecordsPanel() {
        setPanel(1, "Delete records", false);
    }

    private void setFilterRecordsPanel() {
        setPanel(2, "Find Records", false);
    }

    private void setPanel(int panelIndex, String btnLabel, boolean addPanel) {
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

        // Create record button:
        JButton btn = new JButton(btnLabel);

        // Add success label:
        JLabel successLabel = new JLabel("Result: ");

        // Add all attributes to panels:
        panels[panelIndex] = new JPanel();
        panels[panelIndex].setLayout(new FlowLayout());

        String[] operators = new String[] {"==", "!=", "<",
                "<=", ">", ">="};

        panels[panelIndex].add(nameLabel);
        if(!addPanel) panels[panelIndex].add(new JComboBox<String>(operators));
        panels[panelIndex].add(nameTextField);

        panels[panelIndex].add(goodLabel);
        panels[panelIndex].add(goodCheckBox);

        panels[panelIndex].add(lengthLabel);
        if(!addPanel) panels[panelIndex].add(new JComboBox<String>(operators));
        panels[panelIndex].add(lengthTextField);

        panels[panelIndex].add(btn);
        panels[panelIndex].add(successLabel);

        frame.getContentPane().add(panels[panelIndex]);
    }

    private void setTextArea() {
        panels[3] = new JPanel();
        panels[3].setPreferredSize(new Dimension(200, 250));
        textArea = new JTextArea(10, 100);

        JScrollPane vertical = new JScrollPane(textArea);
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panels[3].add(vertical);

        frame.getContentPane().add(panels[3]);
    }


}
