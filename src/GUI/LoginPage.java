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
import javax.swing.JTextField;

public class LoginPage extends JFrame {

    public JTextField Username;
    private final JLabel UsernameLabel, PasswordLabel;
    private final JTextField Password;
    private final JButton Login, Exit;
    final String ManagerName = "Shum";
    final String ManagerPassword = "8";
    public String User;

    public LoginPage() {

        super("Bintang Veterinary Clinic and Boarding System");
        setLayout(null);

        UsernameLabel = new JLabel();
        UsernameLabel.setText("Username :");
        UsernameLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        UsernameLabel.setSize(100, 30);
        UsernameLabel.setLocation(120, 120);
        add(UsernameLabel);

        PasswordLabel = new JLabel();
        PasswordLabel.setText("Password :");
        PasswordLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        PasswordLabel.setSize(100, 30);
        PasswordLabel.setLocation(120, 190);
        add(PasswordLabel);

        Username = new JTextField();
        Username.setSize(150, 30);
        Username.setLocation(220, 120);
        add(Username);

        Password = new JTextField();
        Password.setSize(150, 30);
        Password.setLocation(220, 190);
        add(Password);

        Login = new JButton();
        Login.setText("Login");
        Login.setFont(new Font("Serif", Font.PLAIN, 18));
        Login.setSize(100, 30);
        Login.setLocation(130, 260);
        add(Login);

        Exit = new JButton();
        Exit.setText("Exit");
        Exit.setFont(new Font("Serif", Font.PLAIN, 18));
        Exit.setSize(100, 30);
        Exit.setLocation(250, 260);
        add(Exit);

        eHandler handler = new eHandler();
        Login.addActionListener(handler);
        Exit.addActionListener(handler);

    }

    private class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == Login) {
                if ((Username.getText().equals(ManagerName)) && (Password.getText().equals(ManagerPassword))) {
                    JOptionPane.showMessageDialog(null, "Welcome " + ManagerName + "!",
                            "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                    ManagerPage M = new ManagerPage();
                    M.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    M.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    M.setVisible(true);

                    Password.setText("");
                } else if (Username.getText().length() == 6 && Username.getText().charAt(0) == 'V') {
                    Vet V = new Vet();
                    List<Vet> list = new LinkedList();
                    Vet.populateList(list);
                    for (Vet temp : list) {
                        if (Username.getText().equals(temp.getID())) {
                            if (Password.getText().equals(temp.getVetPassword())) {
                                JOptionPane.showMessageDialog(null, "Welcome " + "Vet " + temp.getFirstName() + "!",
                                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                                VetPage VP = new VetPage(Username.getText());
                                VP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                VP.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                VP.setVisible(true);

                                Password.setText("");
                            }
                        }
                    }
                } else if (Username.getText().length() == 8 && Username.getText().charAt(0) == 'R') {
                    Receptionist R = new Receptionist();
                    List<Receptionist> list = new LinkedList();
                    Receptionist.populateList(list);
                    for (Receptionist temp : list) {
                        if (Username.getText().equals(temp.getID())) {
                            if (Password.getText().equals(temp.getRecPassword())) {
                                JOptionPane.showMessageDialog(null, "Welcome " + "Receptionist " + temp.getFirstName() + "!",
                                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                                ReceptionistPage RP = new ReceptionistPage();
                                RP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                RP.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                RP.setVisible(true);

                                Password.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Wrong Password!",
                                        "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } else if (Username.getText().length() == 5 && Username.getText().charAt(0) == 'B') {
                    BoardingStaff B = new BoardingStaff();
                    List<BoardingStaff> list = new LinkedList();
                    BoardingStaff.populateList(list);
                    for (BoardingStaff temp : list) {
                        if (Username.getText().equals(temp.getID())) {
                            if (Password.getText().equals(temp.getBSPassword())) {
                                JOptionPane.showMessageDialog(null, "Welcome " + "Boarding Staff " + temp.getFirstName() + "!",
                                        "Bintang Veterinary Clinic", JOptionPane.INFORMATION_MESSAGE);
                                BoardingStaffPage BS = new BoardingStaffPage();
                                BS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                BS.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                BS.setVisible(true);

                                Password.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Wrong Password!",
                                        "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password",
                            "Bintang Veterinary Clinic", JOptionPane.ERROR_MESSAGE);
                }
            } else if (event.getSource() == Exit) {
                System.exit(0);
            }
        }
    }
}
