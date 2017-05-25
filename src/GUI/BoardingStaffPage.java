package GUI;

import Classes.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class BoardingStaffPage extends JFrame {

    private JLabel BSLabel, BoardingID, PetID, LastFed, PetStatus;
    private JTextField BoardingIDField, PetIDField, LastFedField;
    private JComboBox PetStatusField;
    private JButton GetTime, UpdateLastFed, UpdateStatus, LogOutButton, CheckOut;
    private JTable BSTable;
    private DefaultTableModel BSModel;
    private JScrollPane BSscrollpane;
    String[] status = {"Healthy", "Not Good", "Critical", "Dying"};

    public BoardingStaffPage() {
        super("Bintang Veterinary Clinic and Boarding System");
        setLayout(null);

        BSLabel = new JLabel();
        BSLabel.setText("* Boarding Staff Page *");
        BSLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        BSLabel.setSize(300, 30);
        BSLabel.setLocation(20, 20);
        add(BSLabel);

        BoardingID = new JLabel("Boarding Service ID :");
        BoardingID.setSize(180, 20);
        BoardingID.setLocation(20, 90);
        add(BoardingID);

        PetID = new JLabel("Pet ID :");
        PetID.setSize(180, 20);
        PetID.setLocation(20, 160);
        add(PetID);

        LastFed = new JLabel("Last Fed :");
        LastFed.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        LastFed.setSize(180, 20);
        LastFed.setLocation(20, 230);
        add(LastFed);

        UpdateLastFed = new JButton("Update Last Fed");
        UpdateLastFed.setSize(180, 30);
        UpdateLastFed.setLocation(100, 330);
        UpdateLastFed.setEnabled(false);
        add(UpdateLastFed);

        PetStatus = new JLabel("Pet Status :");
        PetStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        PetStatus.setSize(180, 20);
        PetStatus.setLocation(20, 400);
        add(PetStatus);

        BoardingIDField = new JTextField();
        BoardingIDField.setSize(200, 20);
        BoardingIDField.setLocation(160, 90);
        add(BoardingIDField);

        PetIDField = new JTextField();
        PetIDField.setSize(200, 20);
        PetIDField.setLocation(160, 160);
        add(PetIDField);

        LastFedField = new JTextField();
        LastFedField.setSize(180, 20);
        LastFedField.setLocation(50, 270);
        add(LastFedField);

        GetTime = new JButton("Get Time");
        GetTime.setSize(80, 20);
        GetTime.setLocation(260, 270);
        add(GetTime);

        PetStatusField = new JComboBox(status);
        PetStatusField.setSize(280, 20);
        PetStatusField.setLocation(50, 440);
        add(PetStatusField);

        UpdateStatus = new JButton("Update Status");
        UpdateStatus.setSize(180, 30);
        UpdateStatus.setLocation(100, 500);
        add(UpdateStatus);

        BSTable = new JTable();
        List<BoardingService> bslist = new LinkedList();
        String[] columnName = {"Boarding Service ID", "Boarding Date", "Pet ID", "Last Fed", "Pet Status"};
        BSModel = new DefaultTableModel(new String[0][0], columnName);
        BoardingService.populateList(bslist);
        for (BoardingService temp : bslist) {
            if (temp.getCustomer().getPet().getBoardingStatus().equals("Board")) {
                String[] y = new String[5];
                y[0] = temp.getBoardingServiceID();
                y[1] = temp.getBoardDate();
                y[2] = temp.getCustomer().getPet().getPetID();
                y[3] = temp.getLastFed();
                y[4] = temp.getCustomer().getPet().getPetStatus();

                BSModel.addRow(y);
            }
        }

        BSTable.setModel(BSModel);
        BSscrollpane = new JScrollPane();
        BSscrollpane.setViewportView(BSTable);
        BSscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        BSscrollpane.setSize(850, 600);
        BSscrollpane.setLocation(450, 20);
        add(BSscrollpane);

        CheckOut = new JButton("Check Out");
        CheckOut.setSize(150, 30);
        CheckOut.setLocation(1150, 650);
        add(CheckOut);

        LogOutButton = new JButton("Log Out");
        LogOutButton.setSize(120, 30);
        LogOutButton.setLocation(120, 600);
        add(LogOutButton);

        Ehandler eh = new Ehandler();
        MouseClickHandler mh = new MouseClickHandler();
        LogOutButton.addActionListener(eh);
        GetTime.addActionListener(eh);
        UpdateLastFed.addActionListener(eh);
        UpdateStatus.addActionListener(eh);
        CheckOut.addActionListener(eh);
        BSTable.addMouseListener(mh);
    }

    private class Ehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == LogOutButton) {
                dispose();
            } else if (event.getSource() == GetTime) {
                UpdateLastFed.setEnabled(true);
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                LastFedField.setText(dateFormat.format(date));
            } else if (event.getSource() == UpdateLastFed) {

                List<BoardingService> list = new LinkedList();
                BoardingService.populateList(list);
                for (BoardingService temp : list) {
                    if (BoardingIDField.getText().equals(temp.getBoardingServiceID())) {
                        temp.setLastFed(LastFedField.getText());
                    }
                }
                BoardingService.writeFile(list);
                JOptionPane.showMessageDialog(null, "Pet Is Fed!",
                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                

            } else if (event.getSource() == UpdateStatus) {

                List<BoardingService> list = new LinkedList();
                BoardingService.populateList(list);
                for (BoardingService temp : list) {
                    if (BoardingIDField.getText().equals(temp.getBoardingServiceID())) {
                        temp.getCustomer().getPet().setPetStatus(PetStatusField.getSelectedItem().toString());
                    }
                }
                BoardingService.writeFile(list);

                List<Appointment> applist = new LinkedList();
                Appointment.populateList(applist);
                for (Appointment cust : applist) {
                    if (PetIDField.getText().equals(cust.getCustomer().getPet().getPetID())) {
                        cust.getCustomer().getPet().setPetStatus(PetStatusField.getSelectedItem().toString());
                    }
                }
                Appointment.writeFile(applist);
                JOptionPane.showMessageDialog(null, "Status Is Updated!",
                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                

            } else if (event.getSource() == CheckOut) {

                List<BoardingService> list = new LinkedList();
                BoardingService bs = null;
                BoardingService.populateList(list);
                for (BoardingService temp : list) {
                    if (BoardingIDField.getText().equals(temp.getBoardingServiceID())) {
                        bs = temp;
                        break;
                    }
                }
                list.remove(bs);
                BoardingService.writeFile(list);

                List<Customer> cust = new LinkedList();
                Customer.populateList(cust);
                for (Customer c : cust) {
                    if (PetIDField.getText().equals(c.getPet().getPetID())) {
                        c.getPet().setBoardingStatus("Unboard");
                    }
                }
                Customer.writeFile(cust);
                JOptionPane.showMessageDialog(null, "Pet Checked Out!",
                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);               
                
            }
        }
    }

    private class MouseClickHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            int row = BSTable.getSelectedRow();

            BoardingIDField.setText(BSTable.getModel().getValueAt(row, 0).toString());
            PetIDField.setText(BSTable.getModel().getValueAt(row, 2).toString());
        }
    }
}
