package UI;

import Database.AppDatabase;
import Database.Record;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class AppInterface extends Interface {

    protected JTable table;
    protected RecordTableModel model;

    public AppInterface() {
        super();

        db = new AppDatabase();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (screenSize.getHeight());
        int width = (int) (4.5 * screenSize.getWidth() / 5);

        frame.setSize(width, height);
        frame.setLocation(0, 0);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.getContentPane().add(setPanel());
        frame.getContentPane().add(setTextArea());

        frame.setVisible(true);
    }

    private JPanel setPanel() {
        // Initialize tab pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add success label:
        JLabel successLabel = new JLabel("Result: ");

        // Add all attributes to panels:
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        tabbedPane.add("Add", initAddPanel());
        tabbedPane.add("Find", initFindPanel());
        //tabbedPane.add("Delete", initDeletePannel()); // Broken

        panel.add(tabbedPane);

        return panel;
    }

    private JPanel initAddPanel() {
        // Initialize panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // textfield for 'name' attribute:
        JLabel nameLabel = new JLabel("Name:");
        final JTextField nameTextField = new JTextField(20);
        nameLabel.setLabelFor(nameTextField);

        // checkbox for 'good' attribute:
        JLabel goodLabel = new JLabel("Good?:");
        final JCheckBox goodCheckBox = new JCheckBox();
        goodLabel.setLabelFor(goodCheckBox);

        // textfield for 'length' attribute:
        JLabel lengthLabel = new JLabel("Length:");
        final JFormattedTextField lengthTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        lengthTextField.setColumns(20);
        lengthLabel.setLabelFor(lengthTextField);

        // Create add button:
        JButton addBtn = new JButton("Add record");

        // Assign add button listener:
        addBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Check for valid input
                        // If all inputs filled, add record
                        if (nameTextField.getText().length() > 0 && lengthTextField.getText().length() > 0) {
                            // Parse record
                            Record r = new Record(
                                    nameTextField.getText(),
                                    goodCheckBox.isSelected(),
                                    Integer.parseInt(lengthTextField.getText().replaceAll(",", ""))
                            );
                            // Add record to database
                            db.add(r);
                            JOptionPane.showMessageDialog(frame, "Success!", "Result", JOptionPane.WARNING_MESSAGE);
                        } else // Otherwise warn user that all inputs must be filled
                        {
                            JOptionPane.showMessageDialog(frame, "All items must be filled.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
        );

        // Add components to panel
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(goodLabel);
        panel.add(goodCheckBox);
        panel.add(lengthLabel);
        panel.add(lengthTextField);
        panel.add(addBtn);

        return panel;
    }

    private JPanel initFindPanel() {
        // Initialize panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Initialize tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Initialize name panel
        Panel namePanel = new Panel();
        namePanel.setLayout(new FlowLayout());

        // textfield for 'name' attribute:
        JLabel nameLabel = new JLabel("Name:");
        final JTextField nameTextField = new JTextField(20);
        nameLabel.setLabelFor(nameTextField);

        // button for 'name' attribute
        JButton findNameBtn = new JButton("Find");
        findNameBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (nameTextField.getText().length() > 0)
                            model.setData(
                                    db.filter(
                                            new Record(
                                                    nameTextField.getText(),
                                                    false,
                                                    null
                                            )
                                    )
                            );
                        else
                            JOptionPane.showMessageDialog(frame, "Must provide name.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
        );

        // Add components to name panel
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        namePanel.add(findNameBtn);

        // Initialize length panel
        Panel lengthPanel = new Panel();
        lengthPanel.setLayout(new FlowLayout());

        // textfield for 'length' attribute:
        JLabel lengthLabel = new JLabel("Length:");
        final JFormattedTextField lengthTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        lengthTextField.setColumns(20);
        lengthLabel.setLabelFor(lengthTextField);

        // button for 'length' attribute
        JButton findLengthBtn = new JButton("Find");
        findLengthBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (lengthTextField.getText().length() > 0) {
                                ArrayList<Record> result = db.filter(
                                        new Record(
                                                null,
                                                false,
                                                Integer.parseInt(
                                                        lengthTextField.getText().replaceAll(",", "")
                                                )
                                        )
                                );
                                model.setData(result);
                            } else
                                JOptionPane.showMessageDialog(frame, "Must provide length.", "Error", JOptionPane.WARNING_MESSAGE);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Length must be integer.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
        );

        // Add components to length panel
        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthTextField);
        lengthPanel.add(findLengthBtn);

        // Initialize good panel
        Panel goodPanel = new Panel();
        goodPanel.setLayout(new FlowLayout());

        // checkbox for 'good' attribute:
        JLabel goodLabel = new JLabel("Good?:");
        final JCheckBox goodCheckBox = new JCheckBox();
        goodLabel.setLabelFor(goodCheckBox);

        // button for 'good' attribute
        JButton findGoodBtn = new JButton("Find");
        findGoodBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        model.setData(
                                db.filter(
                                        new Record(
                                                null,
                                                goodCheckBox.isSelected(),
                                                null
                                        )
                                )
                        );
                    }
                }
        );

        // Add components to good panel
        goodPanel.add(goodLabel);
        goodPanel.add(goodCheckBox);
        goodPanel.add(findGoodBtn);

        // Add tabs to tabbed pane
        tabbedPane.add("Name", namePanel);
        tabbedPane.add("Good", goodPanel);
        tabbedPane.add("Length", lengthPanel);

        // Add components to panel
        panel.add(tabbedPane);

        return panel;
    }

    /*private JPanel initDeletePannel() {
        // Initialize panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Initialize tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Initialize name panel
        Panel namePanel = new Panel();
        namePanel.setLayout(new FlowLayout());

        // textfield for 'name' attribute:
        JLabel nameLabel = new JLabel("Name:");
        final JTextField nameTextField = new JTextField(20);
        nameLabel.setLabelFor(nameTextField);

        // button for 'name' attribute
        JButton deleteBtnName = new JButton("Delete");
        deleteBtnName.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (nameTextField.getText().length() > 0) {
                            db.removeAll(
                                    new Record(
                                            nameTextField.getText(),
                                            false,
                                            null
                                    )
                            );
                            JOptionPane.showMessageDialog(frame, "Done.", "Error", JOptionPane.WARNING_MESSAGE);
                        }else
                            JOptionPane.showMessageDialog(frame, "Must provide name.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
        );

        // Add components to name panel
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        namePanel.add(deleteBtnName);

        // Initialize length panel
        Panel lengthPanel = new Panel();
        lengthPanel.setLayout(new FlowLayout());

        // textfield for 'length' attribute:
        JLabel lengthLabel = new JLabel("Length:");
        final JFormattedTextField lengthTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        lengthTextField.setColumns(20);
        lengthLabel.setLabelFor(lengthTextField);

        // button for 'length' attribute
        JButton deleteLengthBtn = new JButton("Delete");
        deleteLengthBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (lengthTextField.getText().length() > 0) {
                                db.removeAll(
                                        new Record(
                                                null,
                                                false,
                                                Integer.parseInt(
                                                        lengthTextField.getText().replaceAll(",", "")
                                                )
                                        )
                                );
                                JOptionPane.showMessageDialog(frame, "Done.", "Error", JOptionPane.WARNING_MESSAGE);
                            }else
                                JOptionPane.showMessageDialog(frame, "Must provide length.", "Error", JOptionPane.WARNING_MESSAGE);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Length must be integer.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
        );

        // Add components to length panel
        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthTextField);
        lengthPanel.add(deleteLengthBtn);

        // Initialize good panel
        Panel goodPanel = new Panel();
        goodPanel.setLayout(new FlowLayout());

        // checkbox for 'good' attribute:
        JLabel goodLabel = new JLabel("Good?:");
        final JCheckBox goodCheckBox = new JCheckBox();
        goodLabel.setLabelFor(goodCheckBox);

        // button for 'good' attribute
        JButton deleteGoodBtn = new JButton("Delete");
        deleteGoodBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.removeAll(
                                new Record(
                                        null,
                                        goodCheckBox.isSelected(),
                                        null
                                )
                        );
                        JOptionPane.showMessageDialog(frame, "Done.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
        );

        // Add components to good panel
        goodPanel.add(goodLabel);
        goodPanel.add(goodCheckBox);
        goodPanel.add(deleteGoodBtn);

        // Add tabs to tabbed pane
        tabbedPane.add("Name", namePanel);
        tabbedPane.add("Good", goodPanel);
        tabbedPane.add("Length", lengthPanel);

        // Add components to panel
        panel.add(tabbedPane);

        return panel;
    }*/

    private JPanel setTextArea() {
        // Initialize panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Initialize table
        model = new RecordTableModel();
        table = new JTable(model);

        // Nest table in scroll pane
        JScrollPane vertical = new JScrollPane(table);
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Initialize delete button
        JButton deleteBtn = new JButton("Delete Selected");
        deleteBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get selected rows
                        int[] selected = table.getSelectedRows();

                        // Get selected Records
                        ArrayList<Record> toDelete = new ArrayList<Record>();
                        ArrayList<Record> data = model.getData();

                        // Get records for removal from database
                        for (int i : selected)
                            toDelete.add(data.get(i));

                        // Remove records from database
                        for (Record r : toDelete) {
                            db.remove(r);
                        }

                        // Remove records from table model
                        int offset = 0; // Offset considering deleted indices
                        for (int i : selected) {
                            i -= offset; // Adjust target index by offset
                            data.remove(i); // Remove record by index
                            offset++; // Increment offset
                        }

                        // Update table
                        model.fireTableDataChanged();
                        //System.out.println(Arrays.toString(selected));
                    }
                }
        );

        // Prepare panel
        panel.add(deleteBtn);
        panel.add(vertical);

        return panel;
    }

    public class RecordTableModel extends AbstractTableModel {

        private final String[] columns = {"Name", "Good", "Length"};
        private ArrayList<Record> data;

        public RecordTableModel() {
            data = new ArrayList<Record>();
        }

        public ArrayList<Record> getData() {
            return data;
        }

        public void setData(ArrayList<Record> data) {
            this.data = data;
            this.fireTableDataChanged();
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

