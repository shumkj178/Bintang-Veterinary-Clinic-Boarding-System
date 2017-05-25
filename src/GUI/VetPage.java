package GUI;

import Classes.*;
import com.toedter.calendar.JDateChooser;
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

public final class VetPage extends JFrame {

    private String user;
    private JTabbedPane VetTab;

    //MainTab
    private JPanel MainPanel;
    private JLabel VetLabel, CheckDiary, Vet;
    private JButton LogOutButton, CheckDiaryButton;
    private JDateChooser DiaryDate;
    private JTable DiaryTable;
    private DefaultTableModel DiaryModel;
    private JScrollPane DiarySP;

    //ViewPet
    private JPanel PetPanel;
    private JLabel ViewLabel, AppointmentID, PetID, Diagnosis, Prognosis, MedicalCharges;
    private JTextField AppointmentIDField, PetIDField, DiagnosisField, PrognosisField;
    private JSpinner MedicalChargesField;
    private JButton Save;
    private JTable PetTable;
    private DefaultTableModel PetModel;
    private JScrollPane PetSP;

    public VetPage(String user) {

        super("Bintang Veterinary Clinic and Boarding System");
        this.user = user;

        VetTab = new JTabbedPane();

        /**
         * Main Tab
         */
        MainPanel = new JPanel();
        MainPanel.setLayout(null);

        VetLabel = new JLabel();
        VetLabel.setText("* Vet Page *");
        VetLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        VetLabel.setSize(300, 30);
        VetLabel.setLocation(20, 20);
        MainPanel.add(VetLabel);

        Vet = new JLabel("Welcome " + this.user);
        Vet.setSize(120, 20);
        Vet.setLocation(280, 20);
        MainPanel.add(Vet);

        CheckDiary = new JLabel();
        CheckDiary.setText("Check Diary Of :");
        CheckDiary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        CheckDiary.setSize(300, 30);
        CheckDiary.setLocation(20, 80);
        MainPanel.add(CheckDiary);

        DiaryDate = new JDateChooser();
        DiaryDate.setSize(200, 30);
        DiaryDate.setLocation(20, 130);
        MainPanel.add(DiaryDate);

        CheckDiaryButton = new JButton("Check Diary");
        CheckDiaryButton.setSize(200, 30);
        CheckDiaryButton.setLocation(20, 200);
        MainPanel.add(CheckDiaryButton);

        DiaryTable = new JTable();

        LogOutButton = new JButton("Log Out");
        LogOutButton.setSize(100, 30);
        LogOutButton.setLocation(80, 560);
        MainPanel.add(LogOutButton);

        VetTab.add("Vet Menu", MainPanel);

        PetPanel = new JPanel();
        PetPanel.setLayout(null);

        ViewLabel = new JLabel();
        ViewLabel.setText("* Medical *");
        ViewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        ViewLabel.setSize(300, 30);
        ViewLabel.setLocation(20, 20);
        PetPanel.add(ViewLabel);

        AppointmentID = new JLabel("Appointment ID :");
        AppointmentID.setSize(120, 20);
        AppointmentID.setLocation(20, 90);
        PetPanel.add(AppointmentID);
        
        AppointmentIDField = new JTextField();
        AppointmentIDField.setSize(150, 20);
        AppointmentIDField.setLocation(20, 150);
        PetPanel.add(AppointmentIDField);
        
        Diagnosis = new JLabel("Diagnosis :");
        Diagnosis.setSize(120, 20);
        Diagnosis.setLocation(20, 350);
        PetPanel.add(Diagnosis);

        DiagnosisField = new JTextField();
        DiagnosisField.setSize(150, 20);
        DiagnosisField.setLocation(20, 410);
        PetPanel.add(DiagnosisField);

        Prognosis = new JLabel("Prognosis :");
        Prognosis.setSize(120, 20);
        Prognosis.setLocation(20, 220);
        PetPanel.add(Prognosis);

        PrognosisField = new JTextField();
        PrognosisField.setSize(150, 20);
        PrognosisField.setLocation(20, 280);
        PetPanel.add(PrognosisField);

        MedicalCharges = new JLabel("Medical Charges :");
        MedicalCharges.setSize(120, 20);
        MedicalCharges.setLocation(20, 480);
        PetPanel.add(MedicalCharges);

        MedicalChargesField = new JSpinner();
        MedicalChargesField.setSize(150, 20);
        MedicalChargesField.setLocation(20, 540);
        PetPanel.add(MedicalChargesField);

        Save = new JButton("Save");
        Save.setSize(120, 30);
        Save.setLocation(120, 600);
        PetPanel.add(Save);

        PetTable = new JTable();
        String[] columnName = {"Appointment ID", "Pet ID", "Prognosis", "Diagnosis", "Charges", "Pet Status"};
        PetModel = new DefaultTableModel(new String[0][0], columnName);
        List<Appointment> applist = new LinkedList();
        Appointment.populateList(applist);
        for (Appointment app : applist) {
            if (app.getVetAssigned().equals(this.user)) {
                String[] o = new String[6];
                o[0] = app.getAppointmentID();
                o[1] = app.getCustomer().getPet().getPetID();
                o[2] = app.getPrognosis();
                o[3] = app.getDiagnosis();
                o[4] = Integer.toString(app.getMedicalCharges());
                o[5] = app.getCustomer().getPet().getPetStatus();
                
                PetModel.addRow(o);
            }
        }
        PetTable.setModel(PetModel);
        PetSP = new JScrollPane();
        PetSP.setViewportView(PetTable);
        PetSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        PetSP.setSize(850, 600);
        PetSP.setLocation(450, 20);
        PetPanel.add(PetSP);

        VetTab.add("View Pet", PetPanel);

        add(VetTab);

        Ehandler eh = new Ehandler();
        MouseHandler mh = new MouseHandler();
        LogOutButton.addActionListener(eh);
        CheckDiaryButton.addActionListener(eh);
        Save.addActionListener(eh);
        PetTable.addMouseListener(mh);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private class Ehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == LogOutButton) {
                dispose();
            } else if (event.getSource() == CheckDiaryButton) {
                List<Appointment> list = new LinkedList();
                String[] columnName = {"Appointment ID", "Appointment Date", "Appointment Time", "Pet Booked",
                    "Prognosis", "Diagnosis", "Medical Charges"};
                DiaryModel = new DefaultTableModel(new String[0][0], columnName);
                Appointment.populateList(list);
                SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE dd/MM/yyyy");
                String date = sdf.format(DiaryDate.getCalendar().getTime());
                for (Appointment temp : list) {
                    if (temp.getVetAssigned().equals(user)) {
                        if (date.equals(temp.getAppointmentDate())) {
                            String[] o = new String[7];
                            o[0] = temp.getAppointmentID();
                            o[1] = temp.getAppointmentDate();
                            o[2] = temp.getAppointmentTime();
                            o[3] = temp.getPetAssigned();
                            o[4] = temp.getPrognosis();
                            o[5] = temp.getDiagnosis();
                            o[6] = Integer.toString(temp.getMedicalCharges());
                            DiaryModel.addRow(o);
                        }
                    }
                }
                DiaryTable.setModel(DiaryModel);
                DiarySP = new JScrollPane();
                DiarySP.setViewportView(DiaryTable);
                DiarySP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                DiarySP.setSize(800, 600);
                DiarySP.setLocation(450, 25);
                MainPanel.add(DiarySP);
            } else if (event.getSource() == Save) {
                List<Appointment> list = new LinkedList();
                Appointment.populateList(list);
                for (Appointment temp : list) {
                    if (temp.getAppointmentID().equals(AppointmentIDField.getText())) {
                        temp.setPrognosis(PrognosisField.getText());
                        temp.setDiagnosis(DiagnosisField.getText());
                        temp.setCharges((Integer) MedicalChargesField.getValue());
                        temp.setPetSeen("Yes");
                    }
                }
                Appointment.writeFile(list);
                
                JOptionPane.showMessageDialog(null, "Record Saved!", 
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
            int row = PetTable.getSelectedRow();
            
            AppointmentIDField.setText(PetTable.getModel().getValueAt(row, 0).toString());

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
