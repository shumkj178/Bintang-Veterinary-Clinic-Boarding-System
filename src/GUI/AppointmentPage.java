package GUI;

import Classes.*;
import com.toedter.calendar.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class AppointmentPage extends JFrame {

    private JLabel Tittle, CustomerID, PetID, PetType, AppointmentDate, AppointmentTime, VetAssigned, VetAvailable;
    private JTextField CustomerIDField, PetIDField, PetTypeField;
    private JComboBox AppointmentTimeField, VetAssignedField;
    private JButton Confirm, MakeAppointment;
    private JTable CustTable, VetTable, AppTable;
    private DefaultTableModel CustModel, AppModel, VetModel;
    private JScrollPane scrollpane, Vetsp, Appscrollpane;
    private JDateChooser AppointmentDateField;

    public AppointmentPage() {
        super("Bintang Veterinary Clinic and Boarding System");
        setLayout(null);

        Tittle = new JLabel();
        Tittle.setText("* Make Appointment Page *");
        Tittle.setFont(new Font("Times New Roman", Font.BOLD, 22));
        Tittle.setSize(300, 30);
        Tittle.setLocation(20, 20);
        add(Tittle);

        CustomerID = new JLabel("Customer ID :");
        CustomerID.setSize(150, 20);
        CustomerID.setLocation(20, 80);
        add(CustomerID);

        PetID = new JLabel("Pet ID :");
        PetID.setSize(150, 20);
        PetID.setLocation(20, 140);
        add(PetID);

        PetType = new JLabel("Pet Type :");
        PetType.setSize(150, 20);
        PetType.setLocation(20, 200);
        add(PetType);

        AppointmentDate = new JLabel("Appointment Date :");
        AppointmentDate.setSize(150, 20);
        AppointmentDate.setLocation(20, 260);
        add(AppointmentDate);

        AppointmentTime = new JLabel("Appointment Time :");
        AppointmentTime.setSize(150, 20);
        AppointmentTime.setLocation(20, 320);
        add(AppointmentTime);

        VetAssigned = new JLabel("Vet Assigned :");
        VetAssigned.setSize(150, 20);
        VetAssigned.setLocation(20, 380);
        add(VetAssigned);

        CustomerIDField = new JTextField();
        CustomerIDField.setSize(100, 20);
        CustomerIDField.setLocation(150, 80);
        CustomerIDField.setEditable(false);
        add(CustomerIDField);

        Confirm = new JButton("Confirm");
        Confirm.setSize(90, 20);
        Confirm.setLocation(270, 80);
        Confirm.setEnabled(false);
        add(Confirm);

        PetIDField = new JTextField();
        PetIDField.setSize(210, 20);
        PetIDField.setLocation(150, 140);
        PetIDField.setEditable(false);
        add(PetIDField);

        PetTypeField = new JTextField();
        PetTypeField.setSize(210, 20);
        PetTypeField.setLocation(150, 200);
        PetTypeField.setEditable(false);
        add(PetTypeField);

        AppointmentDateField = new JDateChooser();
        AppointmentDateField.setSize(210, 20);
        AppointmentDateField.setLocation(150, 260);
        add(AppointmentDateField);

        String[] time = {"9.00AM", "9.30AM", "10.00AM", "10.30AM", "11.00AM", "11.30AM", "12.00PM", "12.30PM",
            "1.00PM", "1.30PM", "2.00PM", "2.30PM", "3.00PM", "3.30PM", "4.00PM", "4.30PM"};
        AppointmentTimeField = new JComboBox(time);
        AppointmentTimeField.setSize(210, 20);
        AppointmentTimeField.setLocation(150, 320);
        AppointmentTimeField.setEditable(false);
        add(AppointmentTimeField);

        VetAssignedField = new JComboBox();
        VetAssignedField.setSize(210, 20);
        VetAssignedField.setLocation(150, 380);
        VetAssignedField.setEditable(false);
        add(VetAssignedField);

        MakeAppointment = new JButton("Make Appointment");
        MakeAppointment.setSize(200, 30);
        MakeAppointment.setLocation(800, 550);
        MakeAppointment.setEnabled(false);
        add(MakeAppointment);

        CustTable = new JTable();
        List<Customer> list = new LinkedList();
        String[] columnName = {"ID", "First Name", "PetID", "Pet Name", "Pet Type", "Pet Species"};
        CustModel = new DefaultTableModel(new String[0][0], columnName);
        Customer.populateList(list);
        for (Customer temp : list) {
            if (temp.getPet().getPetStatus().equals("Registered")) {
                String[] data = new String[6];
                data[0] = temp.getID();
                data[1] = temp.getFirstName();
                data[2] = temp.getPet().getPetID();
                data[3] = temp.getPet().getPetName();
                data[4] = temp.getPet().getPetType();
                data[5] = temp.getPet().getPetSpecies();
                CustModel.addRow(data);
            }
        }
        CustTable.setModel(CustModel);
        scrollpane = new JScrollPane();
        scrollpane.setViewportView(CustTable);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setSize(600, 250);
        scrollpane.setLocation(400, 15);
        add(scrollpane);

        VetAvailable = new JLabel("Vet Available :");
        VetAvailable.setFont(new Font("Times New Roman", Font.BOLD, 16));
        VetAvailable.setSize(150, 30);
        VetAvailable.setLocation(20, 420);
        add(VetAvailable);

        VetTable = new JTable();
        List<WeekRota> wr = new LinkedList();
        String[] columnName2 = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        VetModel = new DefaultTableModel(new String[0][0], columnName2);
        WeekRota.populateList(wr);
        for (WeekRota x : wr) {
            String[] y = new String[7];
            for (int i = 0; i < 3; i++) {
                y[0] = x.getMonday()[i];
                y[0] = x.getMonday()[i];
                y[0] = x.getMonday()[i];
                y[1] = x.getTuesday()[i];
                y[1] = x.getTuesday()[i];
                y[1] = x.getTuesday()[i];
                y[2] = x.getWednesday()[i];
                y[2] = x.getWednesday()[i];
                y[2] = x.getWednesday()[i];
                y[3] = x.getThursday()[i];
                y[3] = x.getThursday()[i];
                y[3] = x.getThursday()[i];
                y[4] = x.getFriday()[i];
                y[4] = x.getFriday()[i];
                y[4] = x.getFriday()[i];
                y[5] = x.getSaturday()[i];
                y[5] = x.getSaturday()[i];
                y[5] = x.getSaturday()[i];
                y[6] = x.getSunday()[i];
                y[6] = x.getSunday()[i];
                y[6] = x.getSunday()[i];

                VetModel.addRow(y);
            }
        }
        VetTable.setModel(VetModel);
        Vetsp = new JScrollPane();
        Vetsp.setViewportView(VetTable);
        Vetsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        Vetsp.setSize(370, 100);
        Vetsp.setLocation(20, 470);
        add(Vetsp);

        AppTable = new JTable();
        List<Appointment> applist = new LinkedList();
        String[] columnName3 = {"Appointment ID", "Appointment Date", "Appointment Time", "Pet Assigned", "Vet Assigned"};
        AppModel = new DefaultTableModel(new String[0][0], columnName3);
        Appointment.populateList(applist);
        for (Appointment app : applist) {
            String[] y = new String[5];
            y[0] = app.getAppointmentID();
            y[1] = app.getAppointmentDate();
            y[2] = app.getAppointmentTime();
            y[3] = app.getPetAssigned();
            y[4] = app.getVetAssigned();
            AppModel.addRow(y);
        }

        AppTable.setModel(AppModel);
        Appscrollpane = new JScrollPane();
        Appscrollpane.setViewportView(AppTable);
        Appscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Appscrollpane.setSize(600, 250);
        Appscrollpane.setLocation(400, 290);
        add(Appscrollpane);

        Ehandler eh = new Ehandler();
        MouseHandler mh = new MouseHandler();
        Confirm.addActionListener(eh);
        MakeAppointment.addActionListener(eh);
        CustTable.addMouseListener(mh);
    }

    private class Ehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == Confirm) {
                VetAssignedField.removeAllItems();
                MakeAppointment.setEnabled(true);
                AppointmentTimeField.setEditable(true);
                List<Vet> list = new LinkedList();
                Vet.populateList(list);
                for (Vet temp : list) {
                    if (PetTypeField.getText().equals(temp.getExpertise())
                            || PetTypeField.getText().equals(temp.getExpertise2())) {
                        VetAssignedField.addItem(temp.getID());
                    }
                }

            } else if (event.getSource() == MakeAppointment) {
                List<Customer> c = new LinkedList();
                Customer.populateList(c);
                List<Vet> v = new LinkedList();
                Vet.populateList(v);
                Customer x = null;
                Vet y = null;
                for (Customer temp : c) {
                    if (PetIDField.getText().equals(temp.getPet().getPetID())) {
                        x = temp;
                    }
                }
                for (Vet temp2 : v) {
                    if (VetAssignedField.getSelectedItem().toString().equals(temp2.getID())) {
                        y = temp2;
                    }
                }
                Appointment A = new Appointment(y, x);
                try {
                    A.setAppointmentID(A.generateID());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "File Not Found!",
                            "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE dd/MM/yyyy");
                String date = sdf.format(AppointmentDateField.getDate());
                A.setAppointmentDate(date);
                A.setAppointmentTime(AppointmentTimeField.getSelectedItem().toString());
                A.setVetAssigned(VetAssignedField.getSelectedItem().toString());
                A.setPetAssigned(PetIDField.getText());
                A.getCustomer().getPet().setPetStatus("WaitingList");

                List<Appointment> App = new LinkedList();
                Appointment.populateList(App);
                App.add(A);
                Appointment.writeFile(App);

                List<Customer> Cus = new LinkedList();
                Customer.populateList(Cus);
                for (Customer cus : Cus) {
                    if (PetIDField.getText().equals(cus.getPet().getPetID())) {
                        cus.getPet().setPetStatus("WaitingList");
                    }
                }
                Customer.writeFile(Cus);
                try {
                    A.saveGeneratedID();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "File Not Found!",
                            "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "Appointment Made!",
                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            int row = CustTable.getSelectedRow();

            CustomerIDField.setText(CustTable.getModel().getValueAt(row, 0).toString());
            PetIDField.setText(CustTable.getModel().getValueAt(row, 2).toString());
            PetTypeField.setText(CustTable.getModel().getValueAt(row, 4).toString());

            Confirm.setEnabled(true);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

    }
}
