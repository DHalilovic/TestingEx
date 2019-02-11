package UI;

import Database.AppDatabase;
import Database.Record;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AppInterface extends Interface {

    protected JTable table;
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

        frame.getContentPane().add(setPanel());
        frame.getContentPane().add(setTextArea());

        frame.setVisible(true);
    }

    private JPanel setPanel() {
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
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        String[] operators = new String[]{"==", "!=", "<",
                "<=", ">", ">="};

        panel.add(nameLabel);
        panel.add(nameTextField);

        panel.add(goodLabel);
        panel.add(goodCheckBox);

        panel.add(lengthLabel);
        panel.add(lengthTextField);

        panel.add(addBtn);
        panel.add(deleteBtn);
        panel.add(findBtn);
        panel.add(successLabel);

        return panel;
    }

    private JPanel setTextArea() {
        JPanel panel = new JPanel();
        //panels[1].setPreferredSize(new Dimension(200, 250));
        table = new JTable(new RecordTableModel());

        JScrollPane vertical = new JScrollPane(table);
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(vertical);

        return panel;
    }

    public class RecordTableModel extends AbstractTableModel {

        private final String[] columns = {"Name", "Good", "Length"};
        private ArrayList<Record> data;

        public RecordTableModel() {
            data = new ArrayList<Record>();
        }

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

        public String getColumnName(int col) {
            return columns[col];
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

