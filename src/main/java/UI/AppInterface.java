package UI;

import Database.AppDatabase;
import Database.Record;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AppInterface extends Interface {

    protected JPanel[] panels;
    protected JTextArea textArea;
    protected AppDatabase db;

    public AppInterface() {
        super();

        db = new AppDatabase();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (screenSize.getHeight());
        int width = (int) (4.5 * screenSize.getWidth() / 5);

        frame.setSize(width, height);
        frame.setLocation(0, 0);

        frame.setLayout(new GridLayout(2, 1));

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

        String[] operators = new String[]{"==", "!=", "<",
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

    public class RecordTableModel extends AbstractTableModel {

        private final String[] columns = {"Name", "Good", "Length"};
        private ArrayList<Record> data;

        public int getRowCount() {
            int size;

            if (data == null)
                size = 0;
            else
                size = data.size();

            return size;
        }

        public int getColumnCount() {
            return columns.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            Object val = null;

            switch (columnIndex) {
                case 0:
                    val = data.get(rowIndex).getName();
                    break;
                case 1:
                    val = data.get(rowIndex).isGood();
                    break;
                case 2:
                    val = data.get(rowIndex).getLength();
                    break;
            }

            return val;
        }

        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0)
                return String.class;
            else if (columnIndex == 1)
                return Boolean.class;
            else
                return Integer.class;
        }
    }
}

