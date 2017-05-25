package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

import Classes.BoardingStaff;
import Classes.Receptionist;
import Classes.Vet;

public class ManagerPage extends JFrame {

    private final JTabbedPane ManagerTab;

    //MainTab
    private final JPanel MainPanel;
    private final JLabel Tittle, WeekRotaLabel, ReportLabel;
    private final JButton ManagerLogOut, WeekRotaButton, ReportButton;

    //AddEmployeeTab
    private final JPanel AddEmployeePanel;
    private final JLabel AddEmployeeLabel;
    private final JLabel EmployeeID, EmployeeFirstName, EmployeeLastName, EmployeeAddress, EmployeeGender;
    private final JLabel EmployeeAge, EmployeeContactNumber, EmployeeJob, VetExpertise;
    private final JTextField IDField, FirstNameField, LastNameField, AddressField, ContactNumberField, JobField;
    private final JSpinner AgeField;
    private final JComboBox GenderField, ExpertiseField, ExpertiseField2;
    private final ButtonGroup bg;
    private final JRadioButton ReceptionistRB, BoardingStaffRB, VetRB;
    private final JButton GenerateID, AddEmployee, ShowEmployee;
    private JTable EmployeeTable;
    private JScrollPane scrollpane;
    private DefaultTableModel Model, Model2;

    //DeleteEmployeeTab
    private final JPanel DeleteEmployeePanel;
    private final JLabel DeleteEmployeeLabel, EmployeeID_D, EmployeeFirstName_D, EmployeeLastName_D, EmployeeAddress_D;
    private final JLabel EmployeeGender_D, EmployeeAge_D, EmployeeContactNumber_D, EmployeeJob_D, VetExpertise_D;
    private final JTextField IDField_D, FirstNameField_D, LastNameField_D, AddressField_D, ContactNumberField_D, JobField_D;
    private final JSpinner AgeField_D;
    private final JComboBox GenderField_D, ExpertiseField_D, ExpertiseField2_D;
    private final ButtonGroup bg_D;
    private final JRadioButton ReceptionistRB_D, BoardingStaffRB_D, VetRB_D;
    private final JButton EditEmployee, DeleteEmployee, ShowEmployee_D;
    private JTable EmployeeTable_D;
    private JScrollPane scrollpane_D;
    private DefaultTableModel Model_D, Model2_D;

    public ManagerPage() {

        super("Bintang Veterinary Clinic and Boarding System");

        ManagerTab = new JTabbedPane();

        /**
         * Main Tab
         */
        MainPanel = new JPanel();
        MainPanel.setLayout(null);

        Tittle = new JLabel();
        Tittle.setText("* Manager Page *");
        Tittle.setFont(new Font("Times New Roman", Font.BOLD, 22));
        Tittle.setSize(300, 30);
        Tittle.setLocation(20, 20);
        MainPanel.add(Tittle);
        
        WeekRotaLabel = new JLabel();
        WeekRotaLabel.setText("- Week Rota -");
        WeekRotaLabel.setFont(new Font ("Times New Roman", Font.BOLD, 18));
        WeekRotaLabel.setSize(300, 30);
        WeekRotaLabel.setLocation(20, 90);
        MainPanel.add(WeekRotaLabel);
        
        WeekRotaButton = new JButton("Generate Week Rota");
        WeekRotaButton.setSize(180, 30);
        WeekRotaButton.setLocation(20, 150);
        MainPanel.add(WeekRotaButton);
        
        ReportLabel = new JLabel();
        ReportLabel.setText("- Report -");
        ReportLabel.setFont(new Font ("Times New Roman", Font.BOLD, 18));
        ReportLabel.setSize(300, 30);
        ReportLabel.setLocation(20, 220);
        MainPanel.add(ReportLabel);
        
        ReportButton = new JButton("Generate Report");
        ReportButton.setSize(180, 30);
        ReportButton.setLocation(20, 280);
        MainPanel.add(ReportButton);
        
        ManagerLogOut = new JButton("Log Out");
        ManagerLogOut.setSize(180, 30);
        ManagerLogOut.setLocation(20, 560);
        MainPanel.add(ManagerLogOut);

        ManagerTab.add("Manager Menu", MainPanel);

        /**
         * AddEmployeeTab
         */
        AddEmployeePanel = new JPanel();
        AddEmployeePanel.setLayout(null);

        bg = new ButtonGroup();
        ReceptionistRB = new JRadioButton("Receptionist", false);
        ReceptionistRB.setSize(120, 20);
        ReceptionistRB.setLocation(25, 80);
        bg.add(ReceptionistRB);
        AddEmployeePanel.add(ReceptionistRB);

        BoardingStaffRB = new JRadioButton("Boarding Staff", false);
        BoardingStaffRB.setSize(120, 20);
        BoardingStaffRB.setLocation(145, 80);
        bg.add(BoardingStaffRB);
        AddEmployeePanel.add(BoardingStaffRB);

        VetRB = new JRadioButton("Vet", false);
        VetRB.setSize(120, 20);
        VetRB.setLocation(265, 80);
        bg.add(VetRB);
        AddEmployeePanel.add(VetRB);

        AddEmployeeLabel = new JLabel("Choose Employee Type :");
        AddEmployeeLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        AddEmployeeLabel.setSize(300, 30);
        AddEmployeeLabel.setLocation(20, 20);
        AddEmployeePanel.add(AddEmployeeLabel);

        EmployeeID = new JLabel("ID :");
        EmployeeID.setSize(150, 20);
        EmployeeID.setLocation(25, 140);
        AddEmployeePanel.add(EmployeeID);

        EmployeeFirstName = new JLabel("First Name :");
        EmployeeFirstName.setSize(150, 20);
        EmployeeFirstName.setLocation(25, 200);
        AddEmployeePanel.add(EmployeeFirstName);

        EmployeeLastName = new JLabel("Last Name :");
        EmployeeLastName.setSize(150, 20);
        EmployeeLastName.setLocation(25, 260);
        AddEmployeePanel.add(EmployeeLastName);

        EmployeeAddress = new JLabel("Address :");
        EmployeeAddress.setSize(150, 20);
        EmployeeAddress.setLocation(25, 320);
        AddEmployeePanel.add(EmployeeAddress);

        EmployeeGender = new JLabel("Gender :");
        EmployeeGender.setSize(150, 20);
        EmployeeGender.setLocation(25, 380);
        AddEmployeePanel.add(EmployeeGender);

        EmployeeAge = new JLabel("Age :");
        EmployeeAge.setSize(150, 20);
        EmployeeAge.setLocation(25, 440);
        AddEmployeePanel.add(EmployeeAge);

        EmployeeContactNumber = new JLabel("Contact Number :");
        EmployeeContactNumber.setSize(150, 20);
        EmployeeContactNumber.setLocation(25, 500);
        AddEmployeePanel.add(EmployeeContactNumber);

        EmployeeJob = new JLabel("Job :");
        EmployeeJob.setSize(150, 20);
        EmployeeJob.setLocation(25, 560);
        AddEmployeePanel.add(EmployeeJob);

        VetExpertise = new JLabel("Expertise :");
        VetExpertise.setVisible(false);
        VetExpertise.setSize(150, 20);
        VetExpertise.setLocation(25, 620);
        AddEmployeePanel.add(VetExpertise);

        GenerateID = new JButton("Generate");
        GenerateID.setSize(90, 20);
        GenerateID.setLocation(270, 145);
        GenerateID.setEnabled(false);
        AddEmployeePanel.add(GenerateID);

        AddEmployee = new JButton("Add");
        AddEmployee.setSize(120, 30);
        AddEmployee.setLocation(105, 665);
        AddEmployee.setEnabled(false);
        AddEmployeePanel.add(AddEmployee);

        ShowEmployee = new JButton("Show Employee");
        ShowEmployee.setSize(120, 30);
        ShowEmployee.setLocation(235, 665);
        ShowEmployee.setEnabled(false);
        AddEmployeePanel.add(ShowEmployee);

        IDField = new JTextField("");
        IDField.setSize(100, 20);
        IDField.setLocation(150, 145);
        IDField.setEditable(false);
        AddEmployeePanel.add(IDField);

        FirstNameField = new JTextField();
        FirstNameField.setSize(210, 20);
        FirstNameField.setLocation(150, 205);
        AddEmployeePanel.add(FirstNameField);

        LastNameField = new JTextField();
        LastNameField.setSize(210, 20);
        LastNameField.setLocation(150, 265);
        AddEmployeePanel.add(LastNameField);

        AddressField = new JTextField();
        AddressField.setSize(210, 20);
        AddressField.setLocation(150, 325);
        AddEmployeePanel.add(AddressField);

        String[] gender = {"Male", "Female"};
        GenderField = new JComboBox(gender);
        GenderField.setSize(210, 20);
        GenderField.setLocation(150, 385);
        AddEmployeePanel.add(GenderField);

        AgeField = new JSpinner();
        AgeField.setSize(210, 20);
        AgeField.setLocation(150, 445);
        AddEmployeePanel.add(AgeField);

        ContactNumberField = new JTextField();
        ContactNumberField.setSize(210, 20);
        ContactNumberField.setLocation(150, 505);
        AddEmployeePanel.add(ContactNumberField);

        JobField = new JTextField();
        JobField.setEditable(false);
        JobField.setSize(210, 20);
        JobField.setLocation(150, 565);
        AddEmployeePanel.add(JobField);

        String[] expertise = {"Mammals", "Reptiles", "Birds", "Amphibians", "Fish"};
        ExpertiseField = new JComboBox(expertise);
        ExpertiseField.setVisible(false);
        ExpertiseField.setSize(105, 20);
        ExpertiseField.setLocation(150, 625);
        AddEmployeePanel.add(ExpertiseField);

        ExpertiseField2 = new JComboBox(expertise);
        ExpertiseField2.setVisible(false);
        ExpertiseField2.setSize(105, 20);
        ExpertiseField2.setLocation(255, 625);
        AddEmployeePanel.add(ExpertiseField2);

        EmployeeTable = new JTable();

        ManagerTab.add("Add Employee", AddEmployeePanel);

        /**
         * DeleteEmployeeTab
         */
        DeleteEmployeePanel = new JPanel();
        DeleteEmployeePanel.setLayout(null);

        bg_D = new ButtonGroup();
        ReceptionistRB_D = new JRadioButton("Receptionist", false);
        ReceptionistRB_D.setSize(120, 20);
        ReceptionistRB_D.setLocation(25, 80);
        bg_D.add(ReceptionistRB_D);
        DeleteEmployeePanel.add(ReceptionistRB_D);

        BoardingStaffRB_D = new JRadioButton("Boarding Staff", false);
        BoardingStaffRB_D.setSize(120, 20);
        BoardingStaffRB_D.setLocation(145, 80);
        bg_D.add(BoardingStaffRB_D);
        DeleteEmployeePanel.add(BoardingStaffRB_D);

        VetRB_D = new JRadioButton("Vet", false);
        VetRB_D.setSize(120, 20);
        VetRB_D.setLocation(265, 80);
        bg_D.add(VetRB_D);
        DeleteEmployeePanel.add(VetRB_D);

        EmployeeID_D = new JLabel("ID :");
        EmployeeID_D.setSize(150, 20);
        EmployeeID_D.setLocation(25, 140);
        DeleteEmployeePanel.add(EmployeeID_D);

        EmployeeFirstName_D = new JLabel("First Name :");
        EmployeeFirstName_D.setSize(150, 20);
        EmployeeFirstName_D.setLocation(25, 200);
        DeleteEmployeePanel.add(EmployeeFirstName_D);

        EmployeeLastName_D = new JLabel("Last Name :");
        EmployeeLastName_D.setSize(150, 20);
        EmployeeLastName_D.setLocation(25, 260);
        DeleteEmployeePanel.add(EmployeeLastName_D);

        EmployeeAddress_D = new JLabel("Address :");
        EmployeeAddress_D.setSize(150, 20);
        EmployeeAddress_D.setLocation(25, 320);
        DeleteEmployeePanel.add(EmployeeAddress_D);

        EmployeeGender_D = new JLabel("Gender :");
        EmployeeGender_D.setSize(150, 20);
        EmployeeGender_D.setLocation(25, 380);
        DeleteEmployeePanel.add(EmployeeGender_D);

        EmployeeAge_D = new JLabel("Age :");
        EmployeeAge_D.setSize(150, 20);
        EmployeeAge_D.setLocation(25, 440);
        DeleteEmployeePanel.add(EmployeeAge_D);

        EmployeeContactNumber_D = new JLabel("Contact Number :");
        EmployeeContactNumber_D.setSize(150, 20);
        EmployeeContactNumber_D.setLocation(25, 500);
        DeleteEmployeePanel.add(EmployeeContactNumber_D);

        EmployeeJob_D = new JLabel("Job :");
        EmployeeJob_D.setSize(150, 20);
        EmployeeJob_D.setLocation(25, 560);
        DeleteEmployeePanel.add(EmployeeJob_D);

        VetExpertise_D = new JLabel("Expertise :");
        VetExpertise_D.setVisible(false);
        VetExpertise_D.setSize(150, 20);
        VetExpertise_D.setLocation(25, 620);
        DeleteEmployeePanel.add(VetExpertise_D);

        IDField_D = new JTextField("");
        IDField_D.setSize(210, 20);
        IDField_D.setLocation(150, 145);
        IDField_D.setEditable(false);
        DeleteEmployeePanel.add(IDField_D);

        FirstNameField_D = new JTextField();
        FirstNameField_D.setSize(210, 20);
        FirstNameField_D.setLocation(150, 205);
        DeleteEmployeePanel.add(FirstNameField_D);

        LastNameField_D = new JTextField();
        LastNameField_D.setSize(210, 20);
        LastNameField_D.setLocation(150, 265);
        DeleteEmployeePanel.add(LastNameField_D);

        AddressField_D = new JTextField();
        AddressField_D.setSize(210, 20);
        AddressField_D.setLocation(150, 325);
        DeleteEmployeePanel.add(AddressField_D);

        GenderField_D = new JComboBox(gender);
        GenderField_D.setSize(210, 20);
        GenderField_D.setLocation(150, 385);
        DeleteEmployeePanel.add(GenderField_D);

        AgeField_D = new JSpinner();
        AgeField_D.setSize(210, 20);
        AgeField_D.setLocation(150, 445);
        DeleteEmployeePanel.add(AgeField_D);

        ContactNumberField_D = new JTextField();
        ContactNumberField_D.setSize(210, 20);
        ContactNumberField_D.setLocation(150, 505);
        DeleteEmployeePanel.add(ContactNumberField_D);

        JobField_D = new JTextField();
        JobField_D.setEditable(false);
        JobField_D.setSize(210, 20);
        JobField_D.setLocation(150, 565);
        DeleteEmployeePanel.add(JobField_D);

        ExpertiseField_D = new JComboBox(expertise);
        ExpertiseField_D.setVisible(false);
        ExpertiseField_D.setSize(105, 20);
        ExpertiseField_D.setLocation(150, 625);
        DeleteEmployeePanel.add(ExpertiseField_D);

        ExpertiseField2_D = new JComboBox(expertise);
        ExpertiseField2_D.setVisible(false);
        ExpertiseField2_D.setSize(105, 20);
        ExpertiseField2_D.setLocation(255, 625);
        DeleteEmployeePanel.add(ExpertiseField2_D);

        DeleteEmployeeLabel = new JLabel("Choose Employee Type :");
        DeleteEmployeeLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        DeleteEmployeeLabel.setSize(300, 30);
        DeleteEmployeeLabel.setLocation(20, 20);
        DeleteEmployeePanel.add(DeleteEmployeeLabel);

        EditEmployee = new JButton("Edit");
        EditEmployee.setSize(120, 30);
        EditEmployee.setLocation(10, 665);
        EditEmployee.setEnabled(false);
        DeleteEmployeePanel.add(EditEmployee);

        DeleteEmployee = new JButton("Delete");
        DeleteEmployee.setSize(120, 30);
        DeleteEmployee.setLocation(145, 665);
        DeleteEmployee.setEnabled(false);
        DeleteEmployeePanel.add(DeleteEmployee);

        ShowEmployee_D = new JButton("Show Employee");
        ShowEmployee_D.setSize(120, 30);
        ShowEmployee_D.setLocation(275, 665);
        ShowEmployee_D.setEnabled(false);
        DeleteEmployeePanel.add(ShowEmployee_D);

        EmployeeTable_D = new JTable();
        EmployeeTable_D.setToolTipText("Click once to edit");

        ManagerTab.add("Delete Employee", DeleteEmployeePanel);

        add(ManagerTab);

        Ehandler eh = new Ehandler();
        MouseHandler mh = new MouseHandler();

        //Main Tab
        WeekRotaButton.addActionListener(eh);
        ReportButton.addActionListener(eh);
        ManagerLogOut.addActionListener(eh);

        //Add Employee Tab
        ReceptionistRB.addActionListener(eh);
        BoardingStaffRB.addActionListener(eh);
        VetRB.addActionListener(eh);
        GenerateID.addActionListener(eh);
        AddEmployee.addActionListener(eh);
        ShowEmployee.addActionListener(eh);

        //Delete Employee Tab
        ShowEmployee_D.addActionListener(eh);
        ReceptionistRB_D.addActionListener(eh);
        BoardingStaffRB_D.addActionListener(eh);
        VetRB_D.addActionListener(eh);
        EditEmployee.addActionListener(eh);
        DeleteEmployee.addActionListener(eh);
        ReportButton.addActionListener(eh);
        EmployeeTable_D.addMouseListener(mh);
        EmployeeTable_D.addMouseMotionListener(mh);
    }

    private class Ehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            /**
             * Add Employee Tab
             */
            if (event.getSource() == ShowEmployee) {

                if (JobField.getText().equals("Receptionist")) {
                    List<Receptionist> list = new LinkedList();
                    String[] columnName = {"ID", "First Name", "Last Name", "Address", "Gender", "Age", "Contact Number",
                        "Job", "Password"};
                    Model = new DefaultTableModel(new String[0][0], columnName);
                    Receptionist.populateList(list);
                    for (Receptionist temp : list) {
                        String[] data = new String[9];
                        data[0] = temp.getID();
                        data[1] = temp.getFirstName();
                        data[2] = temp.getLastName();
                        data[3] = temp.getAddress();
                        data[4] = temp.getGender();
                        data[5] = Integer.toString(temp.getAge());
                        data[6] = temp.getContactNumber();
                        data[7] = temp.getJob();
                        data[8] = temp.getRecPassword();
                        Model.addRow(data);
                    }
                    EmployeeTable.setModel(Model);
                    scrollpane = new JScrollPane();
                    scrollpane.setViewportView(EmployeeTable);
                    scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollpane.setSize(850, 600);
                    scrollpane.setLocation(450, 15);
                    AddEmployeePanel.add(scrollpane);

                } else if (JobField.getText().equals("Boarding Staff")) {
                    List<BoardingStaff> list = new LinkedList();
                    String[] columnName = {"ID", "First Name", "Last Name", "Address", "Gender", "Age", "Contact Number",
                        "Job", "Password"};
                    Model = new DefaultTableModel(new String[0][0], columnName);
                    BoardingStaff.populateList(list);
                    for (BoardingStaff temp : list) {
                        String[] data = new String[9];
                        data[0] = temp.getID();
                        data[1] = temp.getFirstName();
                        data[2] = temp.getLastName();
                        data[3] = temp.getAddress();
                        data[4] = temp.getGender();
                        data[5] = Integer.toString(temp.getAge());
                        data[6] = temp.getContactNumber();
                        data[7] = temp.getJob();
                        data[8] = temp.getBSPassword();
                        Model.addRow(data);
                    }

                    EmployeeTable.setModel(Model);
                    scrollpane = new JScrollPane();
                    scrollpane.setViewportView(EmployeeTable);
                    scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollpane.setSize(850, 600);
                    scrollpane.setLocation(450, 15);
                    AddEmployeePanel.add(scrollpane);

                } else if (JobField.getText().equals("Vet")) {
                    List<Vet> list = new LinkedList();
                    String[] columnName = {"ID", "First Name", "Last Name", "Address", "Gender", "Age", "Contact Number",
                        "Job", "Expertise", "Expertise 2", "Password"};
                    Model2 = new DefaultTableModel(new String[0][0], columnName);
                    Vet.populateList(list);
                    for (Vet temp : list) {
                        String[] data = new String[11];
                        data[0] = temp.getID();
                        data[1] = temp.getFirstName();
                        data[2] = temp.getLastName();
                        data[3] = temp.getAddress();
                        data[4] = temp.getGender();
                        data[5] = Integer.toString(temp.getAge());
                        data[6] = temp.getContactNumber();
                        data[7] = temp.getJob();
                        data[8] = temp.getExpertise();
                        data[9] = temp.getExpertise2();
                        data[10] = temp.getVetPassword();
                        Model2.addRow(data);
                    }
                    EmployeeTable.setModel(Model2);
                    scrollpane = new JScrollPane();
                    scrollpane.setViewportView(EmployeeTable);
                    scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollpane.setSize(850, 600);
                    scrollpane.setLocation(450, 15);
                    AddEmployeePanel.add(scrollpane);
                }
            } else if (event.getSource() == GenerateID) {
                AddEmployee.setEnabled(true);

                if (ReceptionistRB.isSelected()) {
                    Receptionist R = new Receptionist();
                    try {
                        IDField.setText(R.generateID());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found!",
                                "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (BoardingStaffRB.isSelected()) {
                    BoardingStaff B = new BoardingStaff();
                    try {
                        IDField.setText(B.generateID());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found!",
                                "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (VetRB.isSelected()) {
                    Vet V = new Vet();
                    try {
                        IDField.setText(V.generateID());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found!",
                                "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (event.getSource() == ReceptionistRB) {
                GenerateID.setEnabled(true);
                ExpertiseField.setVisible(false);
                ExpertiseField2.setVisible(false);
                VetExpertise.setVisible(false);
                IDField.setText("");
                JobField.setText("Receptionist");
                ShowEmployee.setEnabled(true);

            } else if (event.getSource() == BoardingStaffRB) {
                GenerateID.setEnabled(true);
                ExpertiseField.setVisible(false);
                ExpertiseField2.setVisible(false);
                VetExpertise.setVisible(false);
                IDField.setText("");
                JobField.setText("Boarding Staff");
                ShowEmployee.setEnabled(true);

            } else if (event.getSource() == VetRB) {
                GenerateID.setEnabled(true);
                ExpertiseField.setVisible(true);
                ExpertiseField2.setVisible(true);
                VetExpertise.setVisible(true);
                IDField.setText("");
                JobField.setText("Vet");
                ShowEmployee.setEnabled(true);

            } else if (event.getSource() == ReceptionistRB_D) {
                ExpertiseField_D.setVisible(false);
                ExpertiseField2_D.setVisible(false);
                VetExpertise_D.setVisible(false);
                ShowEmployee_D.setEnabled(true);

            } else if (event.getSource() == BoardingStaffRB_D) {
                ExpertiseField_D.setVisible(false);
                ExpertiseField2_D.setVisible(false);
                VetExpertise_D.setVisible(false);
                ShowEmployee_D.setEnabled(true);

            } else if (event.getSource() == VetRB_D) {
                ExpertiseField_D.setVisible(true);
                ExpertiseField2_D.setVisible(true);
                VetExpertise_D.setVisible(true);
                ShowEmployee_D.setEnabled(true);
            } else if (event.getSource() == AddEmployee) {

                if (JobField.getText().equals("Receptionist")) {
                    Receptionist R = new Receptionist();
                    R.setID(IDField.getText());
                    R.setFirstName(FirstNameField.getText());
                    R.setLastName(LastNameField.getText());
                    R.setAddress(AddressField.getText());
                    R.setGender(GenderField.getSelectedItem().toString());
                    R.setAge((Integer) AgeField.getValue());
                    R.setContactNumber(ContactNumberField.getText());
                    R.setJob(JobField.getText());
                    R.setRecPassword("r" + IDField.getText().charAt(7));
                    List<Receptionist> list = new LinkedList();
                    Receptionist.populateList(list);
                    list.add(R);
                    Receptionist.writeFile(list);
                    try {
                        R.saveGeneratedID();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found!",
                                "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null, "Receptionist Added",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                    IDField.setText("");
                    FirstNameField.setText("");
                    LastNameField.setText("");
                    AddressField.setText("");
                    AgeField.setValue(0);
                    ContactNumberField.setText("");
                    JobField.setText("");

                } else if (JobField.getText().equals("Boarding Staff")) {
                    BoardingStaff B = new BoardingStaff();
                    B.setID(IDField.getText());
                    B.setFirstName(FirstNameField.getText());
                    B.setLastName(LastNameField.getText());
                    B.setAddress(AddressField.getText());
                    B.setGender(GenderField.getSelectedItem().toString());
                    B.setAge((Integer) AgeField.getValue());
                    B.setContactNumber(ContactNumberField.getText());
                    B.setJob(JobField.getText());
                    B.setBSPassword("b" + IDField.getText().charAt(4));
                    List<BoardingStaff> list = new LinkedList();
                    BoardingStaff.populateList(list);
                    list.add(B);
                    BoardingStaff.writeFile(list);
                    try {
                        B.saveGeneratedID();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found!",
                                "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null, "Boarding Staff Added",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                    IDField.setText("");
                    FirstNameField.setText("");
                    LastNameField.setText("");
                    AddressField.setText("");
                    AgeField.setValue(0);
                    ContactNumberField.setText("");
                    JobField.setText("");

                } else if (JobField.getText().equals("Vet")) {
                    Vet V = new Vet();
                    V.setID(IDField.getText());
                    V.setFirstName(FirstNameField.getText());
                    V.setLastName(LastNameField.getText());
                    V.setAddress(AddressField.getText());
                    V.setGender(GenderField.getSelectedItem().toString());
                    V.setAge((Integer) AgeField.getValue());
                    V.setContactNumber(ContactNumberField.getText());
                    V.setJob(JobField.getText());
                    V.setExpertise(ExpertiseField.getSelectedItem().toString());
                    V.setExpertise2(ExpertiseField2.getSelectedItem().toString());
                    V.setVetPassword("v" + IDField.getText().charAt(5));
                    List<Vet> list = new LinkedList();
                    Vet.populateList(list);
                    list.add(V);
                    Vet.writeFile(list);
                    try {
                        V.saveGeneratedID();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found!",
                                "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null, "Vet Added",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                    IDField.setText("");
                    FirstNameField.setText("");
                    LastNameField.setText("");
                    AddressField.setText("");
                    AgeField.setValue(0);
                    ContactNumberField.setText("");
                    JobField.setText("");

                }
            }/**
             * Delete Tab
             */
            else if (event.getSource() == ShowEmployee_D) {

                if (ReceptionistRB_D.isSelected()) {
                    List<Receptionist> list = new LinkedList();
                    String[] columnName = {"ID", "First Name", "Last Name", "Address", "Gender", "Age", "Contact Number",
                        "Job", "Password"};
                    Model_D = new DefaultTableModel(new String[0][0], columnName);
                    Receptionist.populateList(list);
                    for (Receptionist temp : list) {

                        String[] data = new String[9];
                        data[0] = temp.getID();
                        data[1] = temp.getFirstName();
                        data[2] = temp.getLastName();
                        data[3] = temp.getAddress();
                        data[4] = temp.getGender();
                        data[5] = Integer.toString(temp.getAge());
                        data[6] = temp.getContactNumber();
                        data[7] = temp.getJob();
                        data[8] = temp.getRecPassword();
                        Model_D.addRow(data);
                    }
                    EmployeeTable_D.setModel(Model_D);
                    scrollpane_D = new JScrollPane();
                    scrollpane_D.setViewportView(EmployeeTable_D);
                    scrollpane_D.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollpane_D.setSize(850, 600);
                    scrollpane_D.setLocation(450, 15);
                    DeleteEmployeePanel.add(scrollpane_D);

                } else if (BoardingStaffRB_D.isSelected()) {
                    List<BoardingStaff> list = new LinkedList();
                    String[] columnName = {"ID", "First Name", "Last Name", "Address", "Gender", "Age", "Contact Number",
                        "Job", "Password"};
                    Model_D = new DefaultTableModel(new String[0][0], columnName);
                    BoardingStaff.populateList(list);
                    for (BoardingStaff temp : list) {
                        String[] data = new String[9];
                        data[0] = temp.getID();
                        data[1] = temp.getFirstName();
                        data[2] = temp.getLastName();
                        data[3] = temp.getAddress();
                        data[4] = temp.getGender();
                        data[5] = Integer.toString(temp.getAge());
                        data[6] = temp.getContactNumber();
                        data[7] = temp.getJob();
                        data[8] = temp.getBSPassword();
                        Model_D.addRow(data);
                    }
                    EmployeeTable_D.setModel(Model_D);
                    scrollpane_D = new JScrollPane();
                    scrollpane_D.setViewportView(EmployeeTable_D);
                    scrollpane_D.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollpane_D.setSize(850, 600);
                    scrollpane_D.setLocation(450, 15);
                    scrollpane_D.setEnabled(true);
                    DeleteEmployeePanel.add(scrollpane_D);

                } else if (VetRB_D.isSelected()) {
                    List<Vet> list = new LinkedList();
                    String[] columnName = {"ID", "First Name", "Last Name", "Address", "Gender", "Age", "Contact Number",
                        "Job", "Expertise", "Expertise 2", "Password"};
                    Model2_D = new DefaultTableModel(new String[0][0], columnName);
                    Vet.populateList(list);
                    for (Vet temp : list) {
                        String[] data = new String[11];
                        data[0] = temp.getID();
                        data[1] = temp.getFirstName();
                        data[2] = temp.getLastName();
                        data[3] = temp.getAddress();
                        data[4] = temp.getGender();
                        data[5] = Integer.toString(temp.getAge());
                        data[6] = temp.getContactNumber();
                        data[7] = temp.getJob();
                        data[8] = temp.getExpertise();
                        data[9] = temp.getExpertise2();
                        data[10] = temp.getVetPassword();
                        Model2_D.addRow(data);
                    }
                    EmployeeTable_D.setModel(Model2_D);
                    scrollpane_D = new JScrollPane();
                    scrollpane_D.setViewportView(EmployeeTable_D);
                    scrollpane_D.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollpane_D.setSize(850, 600);
                    scrollpane_D.setLocation(450, 15);
                    scrollpane_D.setEnabled(true);
                    DeleteEmployeePanel.add(scrollpane_D);
                }

            } else if (event.getSource() == DeleteEmployee) {
                if (JobField_D.getText().equals("Receptionist")) {
                    Receptionist recep = null;
                    List<Receptionist> list = new LinkedList();
                    Receptionist.populateList(list);
                    for (Receptionist temp : list) {
                        if (IDField_D.getText().equals(temp.getID())) {
                            recep = temp;
                            break;
                        }
                    }
                    list.remove(recep);
                    Receptionist.writeFile(list);
                    IDField_D.setText("");
                    FirstNameField_D.setText("");
                    LastNameField_D.setText("");
                    AddressField_D.setText("");
                    AgeField_D.setValue(0);
                    ContactNumberField_D.setText("");
                    JobField_D.setText("");

                    JOptionPane.showMessageDialog(null, "Receptionist Deleted!",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);

                } else if (JobField_D.getText().equals("Boarding Staff")) {
                    BoardingStaff boardingstaff = null;
                    List<BoardingStaff> list = new LinkedList();
                    BoardingStaff.populateList(list);
                    for (BoardingStaff temp : list) {
                        if (IDField_D.getText().equals(temp.getID())) {
                            boardingstaff = temp;
                            break;
                        }
                    }
                    list.remove(boardingstaff);
                    BoardingStaff.writeFile(list);
                    IDField_D.setText("");
                    FirstNameField_D.setText("");
                    LastNameField_D.setText("");
                    AddressField_D.setText("");
                    AgeField_D.setValue(0);
                    ContactNumberField_D.setText("");
                    JobField_D.setText("");
                    JOptionPane.showMessageDialog(null, "Boarding Staff Deleted!",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);

                } else if (JobField_D.getText().equals("Vet")) {
                    Vet vet = null;
                    List<Vet> list = new LinkedList();
                    Vet.populateList(list);
                    for (Vet temp : list) {
                        if (IDField_D.getText().equals(temp.getID())) {
                            vet = temp;
                            break;
                        }
                    }
                    list.remove(vet);
                    Vet.writeFile(list);
                    IDField_D.setText("");
                    FirstNameField_D.setText("");
                    LastNameField_D.setText("");
                    AddressField_D.setText("");
                    AgeField_D.setValue(0);
                    ContactNumberField_D.setText("");
                    JobField_D.setText("");
                    JOptionPane.showMessageDialog(null, "Vet Deleted!",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);

                }

            } else if (event.getSource() == EditEmployee) {

                if (JobField_D.getText().equals("Receptionist")) {
                    List<Receptionist> list = new LinkedList();
                    Receptionist.populateList(list);
                    for (Receptionist temp : list) {
                        if (IDField_D.getText().equals(temp.getID())) {
                            temp.setID(IDField_D.getText());
                            temp.setFirstName(FirstNameField_D.getText());
                            temp.setLastName(LastNameField_D.getText());
                            temp.setAddress(AddressField_D.getText());
                            temp.setGender(GenderField_D.getSelectedItem().toString());
                            temp.setAge((Integer) AgeField_D.getValue());
                            temp.setContactNumber(ContactNumberField_D.getText());
                            temp.setJob(JobField_D.getText());
                            temp.setRecPassword("r" + IDField_D.getText().charAt(7));
                        }
                    }
                    Receptionist.writeFile(list);

                    JOptionPane.showMessageDialog(null, "Receptionist Modified!",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                    IDField_D.setText("");
                    FirstNameField_D.setText("");
                    LastNameField_D.setText("");
                    AddressField_D.setText("");
                    AgeField_D.setValue(0);
                    ContactNumberField_D.setText("");
                    JobField_D.setText("");

                } else if (JobField_D.getText().equals("Boarding Staff")) {
                    List<BoardingStaff> list = new LinkedList();
                    BoardingStaff.populateList(list);
                    for (BoardingStaff temp : list) {
                        if (IDField_D.getText().equals(temp.getID())) {
                            temp.setID(IDField_D.getText());
                            temp.setFirstName(FirstNameField_D.getText());
                            temp.setLastName(LastNameField_D.getText());
                            temp.setAddress(AddressField_D.getText());
                            temp.setGender(GenderField_D.getSelectedItem().toString());
                            temp.setAge((Integer) AgeField_D.getValue());
                            temp.setContactNumber(ContactNumberField_D.getText());
                            temp.setJob(JobField_D.getText());
                            temp.setBSPassword("b" + IDField_D.getText().charAt(4));
                        }
                    }
                    BoardingStaff.writeFile(list);

                    JOptionPane.showMessageDialog(null, "BoardingStaff Modified!",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                    IDField_D.setText("");
                    FirstNameField_D.setText("");
                    LastNameField_D.setText("");
                    AddressField_D.setText("");
                    AgeField_D.setValue(0);
                    ContactNumberField_D.setText("");
                    JobField_D.setText("");

                } else if (JobField_D.getText().equals("Vet")) {
                    List<Vet> list = new LinkedList();
                    Vet.populateList(list);
                    for (Vet temp : list) {
                        if (IDField_D.getText().equals(temp.getID())) {
                            temp.setID(IDField_D.getText());
                            temp.setFirstName(FirstNameField_D.getText());
                            temp.setLastName(LastNameField_D.getText());
                            temp.setAddress(AddressField_D.getText());
                            temp.setGender(GenderField_D.getSelectedItem().toString());
                            temp.setAge((Integer) AgeField_D.getValue());
                            temp.setContactNumber(ContactNumberField_D.getText());
                            temp.setJob(JobField_D.getText());
                            temp.setVetPassword("v" + IDField_D.getText().charAt(5));
                            temp.setExpertise(ExpertiseField_D.getSelectedItem().toString());
                            temp.setExpertise2(ExpertiseField2_D.getSelectedItem().toString());
                        }
                    }
                    Vet.writeFile(list);

                    JOptionPane.showMessageDialog(null, "Vet Modified!",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                    IDField_D.setText("");
                    FirstNameField_D.setText("");
                    LastNameField_D.setText("");
                    AddressField_D.setText("");
                    AgeField_D.setValue(0);
                    ContactNumberField_D.setText("");
                    JobField_D.setText("");

                }

            } /**
             * Main Tab
             */
            else if (event.getSource() == ManagerLogOut) {
                dispose();
            } else if (event.getSource() == WeekRotaButton) {
                WeekRotaPage A = new WeekRotaPage();
                A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                A.setSize(920, 600);
                A.setLocation(180, 80);
                A.setVisible(true);
            } else if (event.getSource() == ReportButton) {
                
            }

        }
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent event) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            int row = EmployeeTable_D.getSelectedRow();

            if (ReceptionistRB_D.isSelected()) {
                IDField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 0).toString());
                FirstNameField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 1).toString());
                LastNameField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 2).toString());
                AddressField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 3).toString());
                GenderField_D.setSelectedItem(EmployeeTable_D.getModel().getValueAt(row, 4).toString());
                AgeField_D.setValue(Integer.parseInt(EmployeeTable_D.getModel().getValueAt(row, 5).toString()));
                ContactNumberField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 6).toString());
                JobField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 7).toString());

            } else if (BoardingStaffRB_D.isSelected()) {
                IDField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 0).toString());
                FirstNameField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 1).toString());
                LastNameField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 2).toString());
                AddressField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 3).toString());
                GenderField_D.setSelectedItem(EmployeeTable_D.getModel().getValueAt(row, 4).toString());
                AgeField_D.setValue(Integer.parseInt(EmployeeTable_D.getModel().getValueAt(row, 5).toString()));
                ContactNumberField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 6).toString());
                JobField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 7).toString());
            } else if (VetRB_D.isSelected()) {
                IDField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 0).toString());
                FirstNameField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 1).toString());
                LastNameField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 2).toString());
                AddressField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 3).toString());
                GenderField_D.setSelectedItem(EmployeeTable_D.getModel().getValueAt(row, 4).toString());
                AgeField_D.setValue(Integer.parseInt(EmployeeTable_D.getModel().getValueAt(row, 5).toString()));
                ContactNumberField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 6).toString());
                JobField_D.setText(EmployeeTable_D.getModel().getValueAt(row, 7).toString());
                ExpertiseField_D.setSelectedItem(EmployeeTable_D.getModel().getValueAt(row, 8).toString());
                ExpertiseField2_D.setSelectedItem(EmployeeTable_D.getModel().getValueAt(row, 9).toString());
            }

            EditEmployee.setEnabled(true);
            DeleteEmployee.setEnabled(true);
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
