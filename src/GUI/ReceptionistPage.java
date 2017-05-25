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
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ReceptionistPage extends JFrame {

    private final JTabbedPane RecTab;

    //MainTab
    private final JPanel MainPanel;
    private JLabel RecLabel, AppLabel, BoardLabel;
    private JButton MakeAppointment, EditAppointment, BookBoard, EditBoard, LogOutButton;

    //AddCust
    private final JPanel AddCustomerPanel;
    private JLabel AddCustomerLabel, CustomerID, CustomerFirstName, CustomerLastName, CustomerAddress, CustomerGender;
    private JLabel CustomerAge, CustomerContactNumber, PetName, PetAge, PetType, PetSpecies;
    private JTextField CustIDField, CustFirstNameField, CustLastNameField, CustAddressField, CustContactNumberField;
    private JTextField PetNameField, PetSpeciesField;
    private JSpinner CustAgeField, PetAgeField;
    private JComboBox CustGenderField, PetTypeField;
    private JButton GenerateCustID, AddCustomer, ShowCustomer;
    private JTable CustTable;
    private JScrollPane scrollpane;
    private DefaultTableModel CustModel;

    //DeleteCust
    private final JPanel DeleteCustomerPanel;
    private JLabel DeleteCustomerLabel, CustomerID_D, CustomerFirstName_D, CustomerLastName_D, CustomerAddress_D;
    private JLabel CustomerGender_D, CustomerAge_D, CustomerContactNumber_D;
    private JTextField CustIDField_D, CustFirstNameField_D, CustLastNameField_D, CustAddressField_D;
    private JTextField CustContactNumberField_D;
    private JSpinner CustAgeField_D;
    private JComboBox CustGenderField_D;
    private JButton EditCustomer, DeleteCustomer, ShowCustomer_D;
    private JTable CustTable_D;
    private JScrollPane scrollpane_D;
    private DefaultTableModel CustModel_D;

    public ReceptionistPage() {
        super("Bintang Veterinary Clinic and Boarding System");

        RecTab = new JTabbedPane();

        /**
         * Main Tab
         */
        MainPanel = new JPanel();
        MainPanel.setLayout(null);

        RecLabel = new JLabel();
        RecLabel.setText("* Receptionist Page *");
        RecLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        RecLabel.setSize(300, 30);
        RecLabel.setLocation(20, 20);
        MainPanel.add(RecLabel);

        AppLabel = new JLabel();
        AppLabel.setText("- Appointment -");
        AppLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        AppLabel.setSize(300, 30);
        AppLabel.setLocation(50, 70);
        MainPanel.add(AppLabel);

        BoardLabel = new JLabel();
        BoardLabel.setText("- Boarding Service -");
        BoardLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        BoardLabel.setSize(300, 30);
        BoardLabel.setLocation(40, 250);
        MainPanel.add(BoardLabel);

        MakeAppointment = new JButton("Make Appointment");
        MakeAppointment.setSize(180, 30);
        MakeAppointment.setLocation(20, 130);
        MainPanel.add(MakeAppointment);

        EditAppointment = new JButton("Edit Appontment");
        EditAppointment.setSize(180, 30);
        EditAppointment.setLocation(20, 190);
        MainPanel.add(EditAppointment);

        BookBoard = new JButton("Register Boarding Service");
        BookBoard.setSize(180, 30);
        BookBoard.setLocation(20, 310);
        MainPanel.add(BookBoard);

        EditBoard = new JButton("Edit Boarding Service");
        EditBoard.setSize(180, 30);
        EditBoard.setLocation(20, 370);
        MainPanel.add(EditBoard);

        LogOutButton = new JButton("Log Out");
        LogOutButton.setSize(180, 30);
        LogOutButton.setLocation(20, 560);
        MainPanel.add(LogOutButton);

        RecTab.add("Receptionist Menu", MainPanel);

        /**
         * Add Customer
         */
        AddCustomerPanel = new JPanel();
        AddCustomerPanel.setLayout(null);

        AddCustomerLabel = new JLabel("Add Customer :");
        AddCustomerLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        AddCustomerLabel.setSize(300, 30);
        AddCustomerLabel.setLocation(20, 20);
        AddCustomerPanel.add(AddCustomerLabel);

        CustomerID = new JLabel("ID :");
        CustomerID.setSize(150, 20);
        CustomerID.setLocation(25, 70);
        AddCustomerPanel.add(CustomerID);

        CustomerFirstName = new JLabel("First Name :");
        CustomerFirstName.setSize(150, 20);
        CustomerFirstName.setLocation(25, 120);
        AddCustomerPanel.add(CustomerFirstName);

        CustomerLastName = new JLabel("Last Name :");
        CustomerLastName.setSize(150, 20);
        CustomerLastName.setLocation(25, 170);
        AddCustomerPanel.add(CustomerLastName);

        CustomerAddress = new JLabel("Address :");
        CustomerAddress.setSize(150, 20);
        CustomerAddress.setLocation(25, 220);
        AddCustomerPanel.add(CustomerAddress);

        CustomerGender = new JLabel("Gender :");
        CustomerGender.setSize(150, 20);
        CustomerGender.setLocation(25, 270);
        AddCustomerPanel.add(CustomerGender);

        CustomerAge = new JLabel("Age :");
        CustomerAge.setSize(150, 20);
        CustomerAge.setLocation(25, 320);
        AddCustomerPanel.add(CustomerAge);

        CustomerContactNumber = new JLabel("Contact Number :");
        CustomerContactNumber.setSize(150, 20);
        CustomerContactNumber.setLocation(25, 370);
        AddCustomerPanel.add(CustomerContactNumber);

        PetName = new JLabel("Pet Name :");
        PetName.setSize(150, 20);
        PetName.setLocation(25, 420);
        AddCustomerPanel.add(PetName);

        PetAge = new JLabel("Pet Age :");
        PetAge.setSize(150, 20);
        PetAge.setLocation(25, 470);
        AddCustomerPanel.add(PetAge);

        PetType = new JLabel("Pet Type :");
        PetType.setSize(150, 20);
        PetType.setLocation(25, 520);
        AddCustomerPanel.add(PetType);

        PetSpecies = new JLabel("Pet Species :");
        PetSpecies.setSize(150, 20);
        PetSpecies.setLocation(25, 570);
        AddCustomerPanel.add(PetSpecies);

        CustIDField = new JTextField("");
        CustIDField.setSize(100, 20);
        CustIDField.setLocation(150, 70);
        CustIDField.setEditable(false);
        AddCustomerPanel.add(CustIDField);

        GenerateCustID = new JButton("Generate");
        GenerateCustID.setSize(90, 20);
        GenerateCustID.setLocation(270, 70);
        AddCustomerPanel.add(GenerateCustID);

        CustFirstNameField = new JTextField();
        CustFirstNameField.setSize(210, 20);
        CustFirstNameField.setLocation(150, 120);
        AddCustomerPanel.add(CustFirstNameField);

        CustLastNameField = new JTextField();
        CustLastNameField.setSize(210, 20);
        CustLastNameField.setLocation(150, 170);
        AddCustomerPanel.add(CustLastNameField);

        CustAddressField = new JTextField();
        CustAddressField.setSize(210, 20);
        CustAddressField.setLocation(150, 220);
        AddCustomerPanel.add(CustAddressField);

        String[] gender = {"Male", "Female"};
        CustGenderField = new JComboBox(gender);
        CustGenderField.setSize(210, 20);
        CustGenderField.setLocation(150, 270);
        AddCustomerPanel.add(CustGenderField);

        CustAgeField = new JSpinner();
        CustAgeField.setSize(210, 20);
        CustAgeField.setLocation(150, 320);
        AddCustomerPanel.add(CustAgeField);

        CustContactNumberField = new JTextField();
        CustContactNumberField.setSize(210, 20);
        CustContactNumberField.setLocation(150, 370);
        AddCustomerPanel.add(CustContactNumberField);

        PetNameField = new JTextField();
        PetNameField.setSize(210, 20);
        PetNameField.setLocation(150, 420);
        AddCustomerPanel.add(PetNameField);

        PetAgeField = new JSpinner();
        PetAgeField.setSize(210, 20);
        PetAgeField.setLocation(150, 470);
        AddCustomerPanel.add(PetAgeField);

        String[] type = {"Mammals", "Reptiles", "Amphibians", "Birds", "Fish"};
        PetTypeField = new JComboBox(type);
        PetTypeField.setSize(210, 20);
        PetTypeField.setLocation(150, 520);
        AddCustomerPanel.add(PetTypeField);

        PetSpeciesField = new JTextField();
        PetSpeciesField.setSize(210, 20);
        PetSpeciesField.setLocation(150, 570);
        AddCustomerPanel.add(PetSpeciesField);

        AddCustomer = new JButton("Add");
        AddCustomer.setSize(120, 30);
        AddCustomer.setLocation(105, 640);
        AddCustomer.setEnabled(false);
        AddCustomerPanel.add(AddCustomer);

        ShowCustomer = new JButton("Show Customer");
        ShowCustomer.setSize(120, 30);
        ShowCustomer.setLocation(235, 640);
        AddCustomerPanel.add(ShowCustomer);

        CustTable = new JTable();
        CustTable.setToolTipText("Click once to edit");

        RecTab.add("Add Customer", AddCustomerPanel);

        /**
         * DeleteCust
         */
        DeleteCustomerPanel = new JPanel();
        DeleteCustomerPanel.setLayout(null);

        DeleteCustomerLabel = new JLabel("Manage Customer :");
        DeleteCustomerLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        DeleteCustomerLabel.setSize(300, 30);
        DeleteCustomerLabel.setLocation(20, 20);
        DeleteCustomerPanel.add(DeleteCustomerLabel);

        CustomerID_D = new JLabel("ID :");
        CustomerID_D.setSize(150, 20);
        CustomerID_D.setLocation(25, 70);
        DeleteCustomerPanel.add(CustomerID_D);

        CustomerFirstName_D = new JLabel("First Name :");
        CustomerFirstName_D.setSize(150, 20);
        CustomerFirstName_D.setLocation(25, 140);
        DeleteCustomerPanel.add(CustomerFirstName_D);

        CustomerLastName_D = new JLabel("Last Name :");
        CustomerLastName_D.setSize(150, 20);
        CustomerLastName_D.setLocation(25, 210);
        DeleteCustomerPanel.add(CustomerLastName_D);

        CustomerAddress_D = new JLabel("Address :");
        CustomerAddress_D.setSize(150, 20);
        CustomerAddress_D.setLocation(25, 280);
        DeleteCustomerPanel.add(CustomerAddress_D);

        CustomerGender_D = new JLabel("Gender :");
        CustomerGender_D.setSize(150, 20);
        CustomerGender_D.setLocation(25, 350);
        DeleteCustomerPanel.add(CustomerGender_D);

        CustomerAge_D = new JLabel("Age :");
        CustomerAge_D.setSize(150, 20);
        CustomerAge_D.setLocation(25, 420);
        DeleteCustomerPanel.add(CustomerAge_D);

        CustomerContactNumber_D = new JLabel("Contact Number :");
        CustomerContactNumber_D.setSize(150, 20);
        CustomerContactNumber_D.setLocation(25, 490);
        DeleteCustomerPanel.add(CustomerContactNumber_D);

        CustIDField_D = new JTextField("");
        CustIDField_D.setSize(210, 20);
        CustIDField_D.setLocation(150, 70);
        CustIDField_D.setEditable(false);
        DeleteCustomerPanel.add(CustIDField_D);

        CustFirstNameField_D = new JTextField();
        CustFirstNameField_D.setSize(210, 20);
        CustFirstNameField_D.setLocation(150, 140);
        DeleteCustomerPanel.add(CustFirstNameField_D);

        CustLastNameField_D = new JTextField();
        CustLastNameField_D.setSize(210, 20);
        CustLastNameField_D.setLocation(150, 210);
        DeleteCustomerPanel.add(CustLastNameField_D);

        CustAddressField_D = new JTextField();
        CustAddressField_D.setSize(210, 20);
        CustAddressField_D.setLocation(150, 280);
        DeleteCustomerPanel.add(CustAddressField_D);

        CustGenderField_D = new JComboBox(gender);
        CustGenderField_D.setSize(210, 20);
        CustGenderField_D.setLocation(150, 350);
        DeleteCustomerPanel.add(CustGenderField_D);

        CustAgeField_D = new JSpinner();
        CustAgeField_D.setSize(210, 20);
        CustAgeField_D.setLocation(150, 420);
        DeleteCustomerPanel.add(CustAgeField_D);

        CustContactNumberField_D = new JTextField();
        CustContactNumberField_D.setSize(210, 20);
        CustContactNumberField_D.setLocation(150, 490);
        DeleteCustomerPanel.add(CustContactNumberField_D);

        EditCustomer = new JButton("Edit");
        EditCustomer.setSize(120, 30);
        EditCustomer.setLocation(10, 560);
        EditCustomer.setEnabled(false);
        DeleteCustomerPanel.add(EditCustomer);

        DeleteCustomer = new JButton("Delete");
        DeleteCustomer.setSize(120, 30);
        DeleteCustomer.setLocation(145, 560);
        DeleteCustomer.setEnabled(false);
        DeleteCustomerPanel.add(DeleteCustomer);

        ShowCustomer_D = new JButton("Show Customer");
        ShowCustomer_D.setSize(120, 30);
        ShowCustomer_D.setLocation(275, 560);
        ShowCustomer_D.setEnabled(true);
        DeleteCustomerPanel.add(ShowCustomer_D);

        CustTable_D = new JTable();
        CustTable_D.setToolTipText("Click once to edit");

        RecTab.add("Manage Customer", DeleteCustomerPanel);

        add(RecTab);

        Ehandler eh = new Ehandler();
        MouseHandler mh = new MouseHandler();
        MakeAppointment.addActionListener(eh);
        EditAppointment.addActionListener(eh);
        BookBoard.addActionListener(eh);
        EditBoard.addActionListener(eh);
        LogOutButton.addActionListener(eh);
        GenerateCustID.addActionListener(eh);
        AddCustomer.addActionListener(eh);
        ShowCustomer.addActionListener(eh);
        EditCustomer.addActionListener(eh);
        DeleteCustomer.addActionListener(eh);
        ShowCustomer_D.addActionListener(eh);
        CustTable_D.addMouseListener(mh);
    }

    private class Ehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            //MainTab
            if (event.getSource() == LogOutButton) {
                dispose();
            } else if (event.getSource() == MakeAppointment) {
                AppointmentPage A = new AppointmentPage();
                A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                A.setSize(1050, 650);
                A.setLocation(150, 60);
                A.setVisible(true);
                
            } else if (event.getSource() == EditAppointment) {
                EditAppointmentPage E = new EditAppointmentPage();
                E.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                E.setSize(1050, 650);
                E.setLocation(150, 60);
                E.setVisible(true);
                
            } else if (event.getSource() == BookBoard) {
                BookBoardingServicePage B = new BookBoardingServicePage();
                B.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                B.setSize(1050, 650);
                B.setLocation(150, 60);
                B.setVisible(true);
                
            } else if (event.getSource() == EditBoard) {
                EditBoardingServicePage E = new EditBoardingServicePage();
                E.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                E.setSize(1050, 650);
                E.setLocation(150, 60);
                E.setVisible(true);
            }/**
             * AddCustTab
             */
            else if (event.getSource() == GenerateCustID) {
                AddCustomer.setEnabled(true);
                try {
                    Customer C = new Customer();
                    CustIDField.setText(C.generateID());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "File Not Found!",
                            "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                }
            } else if (event.getSource() == AddCustomer) {
                String x = PetTypeField.getSelectedItem().toString();
                Customer C = new Customer(x);
                C.setID(CustIDField.getText());
                C.setFirstName(CustFirstNameField.getText());
                C.setLastName(CustLastNameField.getText());
                C.setAddress(CustAddressField.getText());
                C.setGender(CustGenderField.getSelectedItem().toString());
                C.setAge((Integer) CustAgeField.getValue());
                C.setContactNumber(CustContactNumberField.getText());
                try {
                    C.getPet().setPetID(C.generatePetID());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "File Not Found!",
                            "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                }
                C.getPet().setPetName(PetNameField.getText());
                C.getPet().setPetAge(PetAgeField.getComponentCount());
                C.getPet().setPetType(PetTypeField.getSelectedItem().toString());
                C.getPet().setPetSpecies(PetSpeciesField.getText());
                C.getPet().setPetOwner(CustIDField.getText());
                C.getPet().setPetStatus("Registered");
                C.getPet().setBoardingStatus("Unboard");

                List<Customer> list = new LinkedList();
                Customer.populateList(list);
                list.add(C);
                Customer.writeFile(list);
                try {
                    C.saveGeneratedID();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "File Not Found!",
                            "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    C.saveGeneratedPetID();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "File Not Found!",
                            "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "Customer Added!",
                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                
                CustIDField.setText("");
                CustFirstNameField.setText("");
                CustLastNameField.setText("");
                CustAddressField.setText("");
                CustAgeField.setValue(0);
                CustContactNumberField.setText("");
                PetNameField.setText("");
                PetAgeField.setValue(0);
                PetSpeciesField.setText("");

            } else if (event.getSource() == ShowCustomer) {
                List<Customer> list = new LinkedList();
                String[] columnName = {"ID", "First Name", "Last Name", "Address", "Gender", "Age", "Contact Number",
                    "Pet Name", "Pet Species"};
                CustModel = new DefaultTableModel(new String[0][0], columnName);
                Customer.populateList(list);
                for (Customer temp : list) {
                    String[] data = new String[10];
                    data[0] = temp.getID();
                    data[1] = temp.getFirstName();
                    data[2] = temp.getLastName();
                    data[3] = temp.getAddress();
                    data[4] = temp.getGender();
                    data[5] = Integer.toString(temp.getAge());
                    data[6] = temp.getContactNumber();
                    data[7] = temp.getPet().getPetName();
                    data[8] = temp.getPet().getPetSpecies();
                    CustModel.addRow(data);

                }
                CustTable.setModel(CustModel);
                scrollpane = new JScrollPane();
                scrollpane.setViewportView(CustTable);
                scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollpane.setSize(850, 600);
                scrollpane.setLocation(450, 15);
                AddCustomerPanel.add(scrollpane);
            } /**
             * Delete Customer Tab
             */
            else if (event.getSource() == ShowCustomer_D) {
                List<Customer> list = new LinkedList();
                String[] columnName = {"ID", "First Name", "Last Name", "Address", "Gender", "Age", "Contact Number",
                    "Pet Name", "Pet Species"};
                CustModel_D = new DefaultTableModel(new String[0][0], columnName);
                Customer.populateList(list);
                for (Customer temp : list) {
                    String[] data = new String[10];
                    data[0] = temp.getID();
                    data[1] = temp.getFirstName();
                    data[2] = temp.getLastName();
                    data[3] = temp.getAddress();
                    data[4] = temp.getGender();
                    data[5] = Integer.toString(temp.getAge());
                    data[6] = temp.getContactNumber();
                    data[7] = temp.getPet().getPetName();
                    data[8] = temp.getPet().getPetSpecies();
                    CustModel_D.addRow(data);

                }
                CustTable_D.setModel(CustModel_D);
                scrollpane_D = new JScrollPane();
                scrollpane_D.setViewportView(CustTable_D);
                scrollpane_D.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollpane_D.setSize(850, 600);
                scrollpane_D.setLocation(450, 15);
                DeleteCustomerPanel.add(scrollpane_D);

            } else if (event.getSource() == EditCustomer) {

                List<Customer> list = new LinkedList();
                Customer.populateList(list);
                for (Customer temp : list) {
                    if (CustIDField_D.getText().equals(temp.getID())) {
                        temp.setID(CustIDField_D.getText());
                        temp.setFirstName(CustFirstNameField_D.getText());
                        temp.setLastName(CustLastNameField_D.getText());
                        temp.setAddress(CustAddressField_D.getText());
                        temp.setGender(CustGenderField_D.getSelectedItem().toString());
                        temp.setAge((Integer) CustAgeField_D.getValue());
                        temp.setContactNumber(CustContactNumberField_D.getText());
                    }
                }
                Customer.writeFile(list);

                JOptionPane.showMessageDialog(null, "Customer Modified!",
                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                CustIDField_D.setText("");
                CustFirstNameField_D.setText("");
                CustLastNameField_D.setText("");
                CustAddressField_D.setText("");
                CustAgeField_D.setValue(0);
                CustContactNumberField_D.setText("");

            } else if (event.getSource() == DeleteCustomer) {

                Customer cust = null;
                List<Customer> list = new LinkedList();
                Customer.populateList(list);
                for (Customer temp : list) {
                    if (CustIDField_D.getText().equals(temp.getID())) {
                        cust = temp;
                        break;
                    }
                }
                list.remove(cust);
                Customer.writeFile(list);
                CustIDField_D.setText("");
                CustFirstNameField_D.setText("");
                CustLastNameField_D.setText("");
                CustAddressField_D.setText("");
                CustAgeField_D.setValue(0);
                CustContactNumberField_D.setText("");

                JOptionPane.showMessageDialog(null, "Customer Deleted!",
                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent event) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            int row = CustTable_D.getSelectedRow();

            CustIDField_D.setText(CustTable_D.getModel().getValueAt(row, 0).toString());
            CustFirstNameField_D.setText(CustTable_D.getModel().getValueAt(row, 1).toString());
            CustLastNameField_D.setText(CustTable_D.getModel().getValueAt(row, 2).toString());
            CustAddressField_D.setText(CustTable_D.getModel().getValueAt(row, 3).toString());
            CustGenderField_D.setSelectedItem(CustTable_D.getModel().getValueAt(row, 4).toString());
            CustAgeField_D.setValue(Integer.parseInt(CustTable_D.getModel().getValueAt(row, 5).toString()));
            CustContactNumberField_D.setText(CustTable_D.getModel().getValueAt(row, 6).toString());

            EditCustomer.setEnabled(true);
            DeleteCustomer.setEnabled(true);
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
