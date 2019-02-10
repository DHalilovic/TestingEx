package UI;

import javax.swing.*;
import java.awt.*;

public class AppInterface extends Interface {

    public AppInterface(){
        super();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (  4 * screenSize.getHeight() / 5 ) ;
        int width = (int) ( 2 * screenSize.getWidth() / 3 ) ;

        frame.setSize(width, height);
        frame.setLocation(0, 0);

        frame.setLayout(new GridLayout(3,1));

        setAddRecordPanel();
        setDeleteRecordsPanel();
        setFilterRecordsPanel();

        frame.setVisible(true);
    }

    private void setAddRecordPanel() {
        setPanel("Add record");
    }

    private void setDeleteRecordsPanel() {
        setPanel("Delete records");
    }

    private void setFilterRecordsPanel() {
        setPanel("Find Records");
    }

    private void setPanel(String btnLabel) {
        // Display textfield for 'id' attribute:
        JLabel idLabel = new JLabel("Id:");
        JTextField idTextField = new JTextField(20);
        idLabel.setLabelFor(idTextField);


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
        JLabel successLabel = new JLabel("");

        // Add all attributes to panel:
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(goodLabel);
        panel.add(goodCheckBox);
        panel.add(lengthLabel);
        panel.add(lengthTextField);
        panel.add(btn);
        panel.add(successLabel);

        frame.getContentPane().add(panel);
    }




}
