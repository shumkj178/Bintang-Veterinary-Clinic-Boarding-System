
package GUI;

import Classes.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Report extends JFrame {
    
    private JLabel Report;
    private JTable ReportTable;
    private DefaultTableModel ReportModel;
    private JScrollPane ReportSP;
    
    public Report(){
        super("Bintang Veterinary Clinic and Boarding System");
        setLayout(null);
        
    }
}
