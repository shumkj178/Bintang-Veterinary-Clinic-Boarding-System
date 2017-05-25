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
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class BookBoardingServicePage extends JFrame {

    private JLabel Tittle, CustomerID, PetID, PetType, PetSpecies, BoardingStatus, BoardDate;
    private JTextField CustomerIDField, PetIDField, PetTypeField, PetSpeciesField, BoardingStatusField;
    private JButton BookBoard;
    private JDateChooser BoardDateField;
    private JTable BoardTable;
    private DefaultTableModel BoardModel;
    private JScrollPane Boardscrollpane;

    public BookBoardingServicePage() {
        super("Bintang Veterinary Clinic and Boarding System");
        setLayout(null);

        Tittle = new JLabel();
        Tittle.setText("* Book Boarding Service Page *");
        Tittle.setFont(new Font("Times New Roman", Font.BOLD, 22));
        Tittle.setSize(350, 30);
        Tittle.setLocation(20, 20);
        add(Tittle);

        CustomerID = new JLabel("Customer ID :");
        CustomerID.setSize(150, 20);
        CustomerID.setLocation(20, 90);
        add(CustomerID);

        PetID = new JLabel("Pet ID :");
        PetID.setSize(150, 20);
        PetID.setLocation(20, 160);
        add(PetID);

        PetType = new JLabel("Pet Type :");
        PetType.setSize(150, 20);
        PetType.setLocation(20, 230);
        add(PetType);

        PetSpecies = new JLabel("Pet Species :");
        PetSpecies.setSize(150, 20);
        PetSpecies.setLocation(20, 300);
        add(PetSpecies);

        BoardingStatus = new JLabel("Boarding Status :");
        BoardingStatus.setSize(150, 20);
        BoardingStatus.setLocation(20, 370);
        add(BoardingStatus);

        BoardDate = new JLabel("Boarding Date :");
        BoardDate.setSize(150, 20);
        BoardDate.setLocation(20, 440);
        add(BoardDate);

        CustomerIDField = new JTextField();
        CustomerIDField.setSize(150, 20);
        CustomerIDField.setLocation(200, 90);
        CustomerIDField.setEditable(false);
        add(CustomerIDField);

        PetIDField = new JTextField();
        PetIDField.setSize(150, 20);
        PetIDField.setLocation(200, 160);
        PetIDField.setEditable(false);
        add(PetIDField);

        PetTypeField = new JTextField();
        PetTypeField.setSize(150, 20);
        PetTypeField.setLocation(200, 230);
        PetTypeField.setEditable(false);
        add(PetTypeField);

        PetSpeciesField = new JTextField();
        PetSpeciesField.setSize(150, 20);
        PetSpeciesField.setLocation(200, 300);
        PetSpeciesField.setEditable(false);
        add(PetSpeciesField);

        BoardingStatusField = new JTextField();
        BoardingStatusField.setSize(150, 20);
        BoardingStatusField.setLocation(200, 370);
        BoardingStatusField.setEditable(false);
        add(BoardingStatusField);

        BoardDateField = new JDateChooser();
        BoardDateField.setSize(150, 20);
        BoardDateField.setLocation(200, 440);
        add(BoardDateField);

        BookBoard = new JButton("Book");
        BookBoard.setSize(150, 30);
        BookBoard.setLocation(120, 520);
        add(BookBoard);

        BoardTable = new JTable();
        List<Customer> list = new LinkedList();
        Customer.populateList(list);
        String[] columnName = {"Customer ID", "Pet ID", "Pet Type", "Pet Species", "Boarding Status"};
        BoardModel = new DefaultTableModel(new String[0][0], columnName);
        for (Customer temp : list) {
            if (temp.getPet().getBoardingStatus().equals("Unboard")) {
                String[] o = new String[5];
                o[0] = temp.getID();
                o[1] = temp.getPet().getPetID();
                o[2] = temp.getPet().getPetType();
                o[3] = temp.getPet().getPetSpecies();
                o[4] = temp.getPet().getBoardingStatus();
                BoardModel.addRow(o);
            }
        }
        BoardTable.setModel(BoardModel);
        Boardscrollpane = new JScrollPane();
        Boardscrollpane.setViewportView(BoardTable);
        Boardscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Boardscrollpane.setSize(600, 550);
        Boardscrollpane.setLocation(400, 15);
        add(Boardscrollpane);

        MouseClickHandler mch = new MouseClickHandler();
        BoardTable.addMouseListener(mch);

        BookBoard.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == BookBoard) {
                            List<Customer> cust = new LinkedList();
                            Customer.populateList(cust);
                            Customer x = null;
                            for (Customer c : cust) {
                                if (PetIDField.getText().equals(c.getPet().getPetID())) {
                                    x = c;
                                    c.getPet().setBoardingStatus("Board");
                                }
                            }
                            Customer.writeFile(cust);

                            List<BoardingService> list = new LinkedList();
                            BoardingService b = new BoardingService(x);
                            BoardingService.populateList(list);
                            try {
                                b.setBoardingServiceID(b.generateID());
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "File Not Found!",
                                        "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                            }
                            SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE dd/MM/yyyy");
                            String date = sdf.format(BoardDateField.getDate());
                            b.setBoardDate(date);
                            b.getCustomer().getPet().setBoardingStatus("Board");
                            list.add(b);
                            BoardingService.writeFile(list);
                            try {
                                b.saveGeneratedID();
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "File Not Found!",
                                        "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                            }
                            JOptionPane.showMessageDialog(null, "Boarding Service Booked!",
                                    "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                });
    }

    private class MouseClickHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            int row = BoardTable.getSelectedRow();

            CustomerIDField.setText(BoardTable.getModel().getValueAt(row, 0).toString());
            PetIDField.setText(BoardTable.getModel().getValueAt(row, 1).toString());
            PetTypeField.setText(BoardTable.getModel().getValueAt(row, 2).toString());
            PetSpeciesField.setText(BoardTable.getModel().getValueAt(row, 2).toString());
            BoardingStatusField.setText(BoardTable.getModel().getValueAt(row, 3).toString());
        }
    }

}
