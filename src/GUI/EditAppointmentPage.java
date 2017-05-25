package GUI;

import Classes.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import com.toedter.calendar.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class EditAppointmentPage extends JFrame {

    private JLabel Tittle, AppointmentID, PetID, PetType, AppointmentDate, AppointmentTime, VetAssigned, VetAvailable;
    private JTextField AppointmentIDField, PetIDField, PetTypeField;
    private JComboBox AppointmentTimeField, VetAssignedField;
    private JButton Confirm, EditAppointment, CancelAppointment;
    private JTable VetTable, AppTable;
    private DefaultTableModel AppModel, VetModel;
    private JScrollPane Vetsp, Appscrollpane;
    private JDateChooser AppointmentDateField;

    public EditAppointmentPage() {
        super("Bintang Veterinary Clinic and Boarding System");
        setLayout(null);

        Tittle = new JLabel();
        Tittle.setText("* Edit Appointment Page *");
        Tittle.setFont(new Font("Times New Roman", Font.BOLD, 22));
        Tittle.setSize(300, 30);
        Tittle.setLocation(20, 20);
        add(Tittle);

        AppointmentID = new JLabel("Appointment ID :");
        AppointmentID.setSize(150, 20);
        AppointmentID.setLocation(20, 80);
        add(AppointmentID);

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

        AppointmentIDField = new JTextField();
        AppointmentIDField.setSize(100, 20);
        AppointmentIDField.setLocation(150, 80);
        AppointmentIDField.setEditable(false);
        add(AppointmentIDField);

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

        EditAppointment = new JButton("Edit Appointment");
        EditAppointment.setSize(200, 30);
        EditAppointment.setLocation(550, 550);
        EditAppointment.setEnabled(false);
        add(EditAppointment);

        CancelAppointment = new JButton("Cancel Appointment");
        CancelAppointment.setSize(200, 30);
        CancelAppointment.setLocation(800, 550);
        CancelAppointment.setEnabled(false);
        add(CancelAppointment);

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
        String[] columnName3 = {"Appointment ID", "Appointment Date", "Appointment Time", "Vet Assigned", "Pet Assigned", "Pet Type"};
        AppModel = new DefaultTableModel(new String[0][0], columnName3);
        Appointment.populateList(applist);
        List<Customer> custlist = new LinkedList();
        Customer.populateList(custlist);
        for (Appointment app : applist) {
            String[] y = new String[6];
            y[0] = app.getAppointmentID();
            y[1] = app.getAppointmentDate();
            y[2] = app.getAppointmentTime();
            y[3] = app.getVetAssigned();
            y[4] = app.getPetAssigned();
            for (Customer cust : custlist) {
                y[5] = cust.getPet().getPetType();
            }

            AppModel.addRow(y);
        }

        AppTable.setModel(AppModel);
        Appscrollpane = new JScrollPane();
        Appscrollpane.setViewportView(AppTable);
        Appscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Appscrollpane.setSize(600, 500);
        Appscrollpane.setLocation(400, 15);
        add(Appscrollpane);

        Ehandler eh = new Ehandler();
        MouseHandler mh = new MouseHandler();
        Confirm.addActionListener(eh);
        EditAppointment.addActionListener(eh);
        CancelAppointment.addActionListener(eh);
        AppTable.addMouseListener(mh);
    }

    private class Ehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == Confirm) {
                VetAssignedField.removeAllItems();
                EditAppointment.setEnabled(true);
                CancelAppointment.setEnabled(true);
                AppointmentTimeField.setEditable(true);
                List<Vet> list = new LinkedList();
                Vet.populateList(list);
                for (Vet temp : list) {
                    if (PetTypeField.getText().equals(temp.getExpertise())
                            || PetTypeField.getText().equals(temp.getExpertise2())) {
                        VetAssignedField.addItem(temp.getID());
                    }
                }

            } else if (event.getSource() == EditAppointment) {
                List<Appointment> list = new LinkedList();
                Appointment.populateList(list);
                for (Appointment temp : list) {
                    if (AppointmentIDField.getText().equals(temp.getAppointmentID())) {
                        temp.setAppointmentID(AppointmentIDField.getText());
                        SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE dd/MM/yyyy");
                        String date = sdf.format(AppointmentDateField.getDate());
                        temp.setAppointmentDate(date);
                        temp.setAppointmentTime(AppointmentTimeField.getSelectedItem().toString());
                        temp.setVetAssigned(VetAssignedField.getSelectedItem().toString());
                        temp.setPetAssigned(PetIDField.getText());
                        temp.getCustomer().getPet().setPetStatus("WaitingList");
                    }
                }
                Appointment.writeFile(list);

                List<Customer> Cus = new LinkedList();
                Customer.populateList(Cus);
                for (Customer cus : Cus) {
                    if (PetIDField.getText().equals(cus.getPet().getPetID())) {
                        cus.getPet().setPetStatus("WaitingList");
                    }
                }
                Customer.writeFile(Cus);
                JOptionPane.showMessageDialog(null, "Appointment Edited!",
                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);

            } else if (event.getSource() == CancelAppointment) {
                Appointment app = null;
                List<Appointment> list = new LinkedList();
                Appointment.populateList(list);
                for (Appointment temp : list) {
                    if (AppointmentIDField.getText().equals(temp.getAppointmentID())) {
                        app = temp;
                        break;
                    }
                }
                list.remove(app);
                Appointment.writeFile(list);

                List<Customer> cust = new LinkedList();
                Customer.populateList(cust);
                for (Customer temp2 : cust) {
                    if (PetIDField.getText().equals(temp2.getPet().getPetID())) {
                        temp2.getPet().setPetStatus("Registered");
                    }
                }
                Customer.writeFile(cust);
                JOptionPane.showMessageDialog(null, "Appointment Deleted!",
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
            int row = AppTable.getSelectedRow();

            AppointmentIDField.setText(AppTable.getModel().getValueAt(row, 0).toString());
            PetIDField.setText(AppTable.getModel().getValueAt(row, 4).toString());
            PetTypeField.setText(AppTable.getModel().getValueAt(row, 5).toString());

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
