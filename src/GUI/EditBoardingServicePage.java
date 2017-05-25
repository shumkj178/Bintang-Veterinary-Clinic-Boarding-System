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
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class EditBoardingServicePage extends JFrame {

    private JLabel Tittle, CustomerID, PetID, PetType, PetSpecies, BoardingStatus, BoardingID, BoardingDate;
    private JTextField CustomerIDField, PetIDField, PetTypeField, PetSpeciesField, BoardingStatusField, BSIDField;
    private JButton EditBoard, CancelBoard;
    private JDateChooser BoardDateField;
    private JTable BoardTable;
    private DefaultTableModel BoardModel;
    private JScrollPane Boardscrollpane;

    public EditBoardingServicePage() {
        super("Bintang Veterinary Clinic and Boarding System");
        setLayout(null);

        Tittle = new JLabel();
        Tittle.setText("* Edit Boarding Service Page *");
        Tittle.setFont(new Font("Times New Roman", Font.BOLD, 22));
        Tittle.setSize(300, 30);
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

        BoardingID = new JLabel("Boarding Service ID :");
        BoardingID.setSize(180, 20);
        BoardingID.setLocation(20, 440);
        add(BoardingID);

        BoardingDate = new JLabel("Boarding Date :");
        BoardingDate.setSize(180, 20);
        BoardingDate.setLocation(20, 510);
        add(BoardingDate);

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

        BSIDField = new JTextField();
        BSIDField.setSize(150, 20);
        BSIDField.setLocation(200, 440);
        BSIDField.setEditable(false);
        add(BSIDField);

        BoardDateField = new JDateChooser();
        BoardDateField.setSize(150, 20);
        BoardDateField.setLocation(200, 510);
        add(BoardDateField);

        EditBoard = new JButton("Edit");
        EditBoard.setSize(150, 30);
        EditBoard.setLocation(20, 570);
        add(EditBoard);

        CancelBoard = new JButton("Cancel");
        CancelBoard.setSize(150, 30);
        CancelBoard.setLocation(200, 570);
        add(CancelBoard);

        BoardTable = new JTable();
        List<Customer> list = new LinkedList();
        Customer.populateList(list);
        String[] columnName = {"Customer ID", "Pet ID", "Pet Type", "Pet Species", "Boarding Status",
            "Boarding Service ID", "Boarding Date"};
        BoardModel = new DefaultTableModel(new String[0][0], columnName);
        List<BoardingService> bs = new LinkedList();
        BoardingService.populateList(bs);
        for (Customer temp : list) {
            if (temp.getPet().getBoardingStatus().equals("Board")) {
                String[] o = new String[7];
                o[0] = temp.getID();
                o[1] = temp.getPet().getPetID();
                o[2] = temp.getPet().getPetType();
                o[3] = temp.getPet().getPetSpecies();
                o[4] = temp.getPet().getBoardingStatus();
                for (BoardingService temp2 : bs) {
                    o[5] = temp2.getBoardingServiceID();
                    o[6] = temp2.getBoardDate();
                }
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

        CancelBoard.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == CancelBoard) {
                            BoardingService bs = null;
                            List<BoardingService> list = new LinkedList();
                            BoardingService.populateList(list);
                            for (BoardingService temp : list) {
                                if (BSIDField.getText().equals(temp.getBoardingServiceID())) {
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
                            JOptionPane.showMessageDialog(null, "Booking Deleted!",
                                    "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }

                });
        EditBoard.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == EditBoard) {

                            List<BoardingService> list = new LinkedList();
                            BoardingService.populateList(list);
                            for (BoardingService x : list) {
                                if (x.getBoardingServiceID().equals(BSIDField.getText())) {
                                    SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE dd/MM/yyyy");
                                    String date = sdf.format(BoardDateField.getDate());
                                    x.setBoardDate(date);
                                }
                            }
                            BoardingService.writeFile(list);
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
            BSIDField.setText(BoardTable.getModel().getValueAt(row, 5).toString());
        }
    }

}
