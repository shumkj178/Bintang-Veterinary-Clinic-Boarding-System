package GUI;

import Classes.*;
import com.toedter.calendar.JMonthChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
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

public class WeekRotaPage extends JFrame {

    private JTabbedPane WRTab;
    private String[] vet = {"Vet001", "Vet002", "Vet003", "Vet004", "Vet005", "Vet006", "Vet007", "Vet008"};

    //Add Tab
    private JPanel AddPanel;
    private JLabel CreateWeekRota, Month, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
    private JComboBox MondayVet1, MondayVet2, MondayVet3, TuesdayVet1, TuesdayVet2, TuesdayVet3;
    private JComboBox WednesdayVet1, WednesdayVet2, WednesdayVet3, ThursdayVet1, ThursdayVet2, ThursdayVet3;
    private JComboBox FridayVet1, FridayVet2, FridayVet3, SaturdayVet1, SaturdayVet2, SaturdayVet3;
    private JComboBox SundayVet1, SundayVet2, SundayVet3;
    private JMonthChooser month;
    private JButton AutoAssign, Create;
    private JTable weekrota;
    private DefaultTableModel wrmodel;
    private JScrollPane wrscrollpane;

    //DeleteTab
    private JPanel DeletePanel;

    public WeekRotaPage() {

        super("Bintang Veterinary Clinic and Boarding System");

        WRTab = new JTabbedPane();

        /**
         * Add Tab
         */
        AddPanel = new JPanel();
        AddPanel.setLayout(null);

        CreateWeekRota = new JLabel();
        CreateWeekRota.setText("Create Week Rota :");
        CreateWeekRota.setFont(new Font("Times New Roman", Font.BOLD, 22));
        CreateWeekRota.setSize(300, 30);
        CreateWeekRota.setLocation(20, 20);
        AddPanel.add(CreateWeekRota);

        Month = new JLabel("For Month :");
        Month.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        Month.setSize(120, 20);
        Month.setLocation(20, 80);
        AddPanel.add(Month);

        month = new JMonthChooser();
        month.setSize(120, 20);
        month.setLocation(150, 80);
        AddPanel.add(month);

        Monday = new JLabel("Monday :");
        Monday.setSize(120, 20);
        Monday.setLocation(20, 130);
        AddPanel.add(Monday);

        MondayVet1 = new JComboBox(vet);
        MondayVet1.setSize(80, 20);
        MondayVet1.setLocation(150, 130);
        AddPanel.add(MondayVet1);

        MondayVet2 = new JComboBox(vet);
        MondayVet2.setSize(80, 20);
        MondayVet2.setLocation(250, 130);
        AddPanel.add(MondayVet2);

        MondayVet3 = new JComboBox(vet);
        MondayVet3.setSize(80, 20);
        MondayVet3.setLocation(350, 130);
        AddPanel.add(MondayVet3);

        Tuesday = new JLabel("Tuesday :");
        Tuesday.setSize(120, 20);
        Tuesday.setLocation(20, 180);
        AddPanel.add(Tuesday);

        TuesdayVet1 = new JComboBox(vet);
        TuesdayVet1.setSize(80, 20);
        TuesdayVet1.setLocation(150, 180);
        AddPanel.add(TuesdayVet1);

        TuesdayVet2 = new JComboBox(vet);
        TuesdayVet2.setSize(80, 20);
        TuesdayVet2.setLocation(250, 180);
        AddPanel.add(TuesdayVet2);

        TuesdayVet3 = new JComboBox(vet);
        TuesdayVet3.setSize(80, 20);
        TuesdayVet3.setLocation(350, 180);
        AddPanel.add(TuesdayVet3);

        Wednesday = new JLabel("Wednesday :");
        Wednesday.setSize(120, 20);
        Wednesday.setLocation(20, 230);
        AddPanel.add(Wednesday);

        WednesdayVet1 = new JComboBox(vet);
        WednesdayVet1.setSize(80, 20);
        WednesdayVet1.setLocation(150, 230);
        AddPanel.add(WednesdayVet1);

        WednesdayVet2 = new JComboBox(vet);
        WednesdayVet2.setSize(80, 20);
        WednesdayVet2.setLocation(250, 230);
        AddPanel.add(WednesdayVet2);

        WednesdayVet3 = new JComboBox(vet);
        WednesdayVet3.setSize(80, 20);
        WednesdayVet3.setLocation(350, 230);
        AddPanel.add(WednesdayVet3);

        Thursday = new JLabel("Thursday :");
        Thursday.setSize(120, 20);
        Thursday.setLocation(20, 280);
        AddPanel.add(Thursday);

        ThursdayVet1 = new JComboBox(vet);
        ThursdayVet1.setSize(80, 20);
        ThursdayVet1.setLocation(150, 280);
        AddPanel.add(ThursdayVet1);

        ThursdayVet2 = new JComboBox(vet);
        ThursdayVet2.setSize(80, 20);
        ThursdayVet2.setLocation(250, 280);
        AddPanel.add(ThursdayVet2);

        ThursdayVet3 = new JComboBox(vet);
        ThursdayVet3.setSize(80, 20);
        ThursdayVet3.setLocation(350, 280);
        AddPanel.add(ThursdayVet3);

        Friday = new JLabel("Friday :");
        Friday.setSize(120, 20);
        Friday.setLocation(20, 330);
        AddPanel.add(Friday);

        FridayVet1 = new JComboBox(vet);
        FridayVet1.setSize(80, 20);
        FridayVet1.setLocation(150, 330);
        AddPanel.add(FridayVet1);

        FridayVet2 = new JComboBox(vet);
        FridayVet2.setSize(80, 20);
        FridayVet2.setLocation(250, 330);
        AddPanel.add(FridayVet2);

        FridayVet3 = new JComboBox(vet);
        FridayVet3.setSize(80, 20);
        FridayVet3.setLocation(350, 330);
        AddPanel.add(FridayVet3);

        Saturday = new JLabel("Saturday :");
        Saturday.setSize(120, 20);
        Saturday.setLocation(20, 380);
        AddPanel.add(Saturday);

        SaturdayVet1 = new JComboBox(vet);
        SaturdayVet1.setSize(80, 20);
        SaturdayVet1.setLocation(150, 380);
        AddPanel.add(SaturdayVet1);

        SaturdayVet2 = new JComboBox(vet);
        SaturdayVet2.setSize(80, 20);
        SaturdayVet2.setLocation(250, 380);
        AddPanel.add(SaturdayVet2);

        SaturdayVet3 = new JComboBox(vet);
        SaturdayVet3.setSize(80, 20);
        SaturdayVet3.setLocation(350, 380);
        AddPanel.add(SaturdayVet3);

        Sunday = new JLabel("Sunday :");
        Sunday.setSize(120, 20);
        Sunday.setLocation(20, 430);
        AddPanel.add(Sunday);

        SundayVet1 = new JComboBox(vet);
        SundayVet1.setSize(80, 20);
        SundayVet1.setLocation(150, 430);
        AddPanel.add(SundayVet1);

        SundayVet2 = new JComboBox(vet);
        SundayVet2.setSize(80, 20);
        SundayVet2.setLocation(250, 430);
        AddPanel.add(SundayVet2);

        SundayVet3 = new JComboBox(vet);
        SundayVet3.setSize(80, 20);
        SundayVet3.setLocation(350, 430);
        AddPanel.add(SundayVet3);

        AutoAssign = new JButton("Auto Assign");
        AutoAssign.setSize(150, 25);
        AutoAssign.setLocation(80, 480);
        AddPanel.add(AutoAssign);

        Create = new JButton("Create Week Rota");
        Create.setSize(150, 25);
        Create.setLocation(250, 480);
        //Create.setEnabled(false);
        AddPanel.add(Create);

        weekrota = new JTable();
        List<Vet> list = new LinkedList();
        String[] columnName = {"Vet", "Vet Name", "Expertise", "Expertise2"};
        wrmodel = new DefaultTableModel(new String[0][0], columnName);
        Vet.populateList(list);
        for (Vet temp : list) {
            String[] data = new String[4];
            data[0] = temp.getID();
            data[1] = temp.getFirstName();
            data[2] = temp.getExpertise();
            data[3] = temp.getExpertise2();
            wrmodel.addRow(data);
        }
        weekrota.setModel(wrmodel);
        wrscrollpane = new JScrollPane();
        wrscrollpane.setViewportView(weekrota);
        wrscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        wrscrollpane.setSize(435, 300);
        wrscrollpane.setLocation(450, 25);
        AddPanel.add(wrscrollpane);

        WRTab.add("Generate Week Rota", AddPanel);

        add(WRTab);

        AutoAssign.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == AutoAssign) {
                            

                        }
                    }
                }
        );
        Create.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == Create) {
                            String[] mon = new String[3];
                            String[] tues = new String[3];
                            String[] wed = new String[3];
                            String[] thurs = new String[3];
                            String[] fri = new String[3];
                            String[] sat = new String[3];
                            String[] sun = new String[3];

                            mon[0] = MondayVet1.getSelectedItem().toString();
                            mon[1] = MondayVet2.getSelectedItem().toString();
                            mon[2] = MondayVet3.getSelectedItem().toString();
                            tues[0] = TuesdayVet1.getSelectedItem().toString();
                            tues[1] = TuesdayVet2.getSelectedItem().toString();
                            tues[2] = TuesdayVet3.getSelectedItem().toString();
                            wed[0] = WednesdayVet1.getSelectedItem().toString();
                            wed[1] = WednesdayVet2.getSelectedItem().toString();
                            wed[2] = WednesdayVet3.getSelectedItem().toString();
                            thurs[0] = ThursdayVet1.getSelectedItem().toString();
                            thurs[1] = ThursdayVet2.getSelectedItem().toString();
                            thurs[2] = ThursdayVet3.getSelectedItem().toString();
                            fri[0] = FridayVet1.getSelectedItem().toString();
                            fri[1] = FridayVet2.getSelectedItem().toString();
                            fri[2] = FridayVet3.getSelectedItem().toString();
                            sat[0] = SaturdayVet1.getSelectedItem().toString();
                            sat[1] = SaturdayVet2.getSelectedItem().toString();
                            sat[2] = SaturdayVet3.getSelectedItem().toString();
                            sun[0] = SundayVet1.getSelectedItem().toString();
                            sun[1] = SundayVet2.getSelectedItem().toString();
                            sun[2] = SundayVet3.getSelectedItem().toString();

                            WeekRota w = new WeekRota();
                            try {
                                w.setWeekRotaID(w.generateID());
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "File Not Found!",
                                        "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                            }
                            int date = (month.getMonth() + 1);                            
                            w.setWeekRotaMonth(date);
                            w.setMonday(mon);
                            w.setTuesday(tues);
                            w.setWednesday(wed);
                            w.setThursday(thurs);
                            w.setFriday(fri);
                            w.setSaturday(sat);
                            w.setSunday(sun);

                            List<WeekRota> list = new LinkedList();
                            WeekRota.populateList(list);
                            list.add(w);
                            WeekRota.writeFile(list);
                            JOptionPane.showMessageDialog(null, "Week Rota Generated!",
                                    "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
        );
    }
}
