package bvcb;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import GUI.LoginPage;

public class BVCB {

    public static void main(String[] args) {

       try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());

                    LoginPage L = new LoginPage();
                    L.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    L.setSize(500, 500);
                    L.setLocation(250, 100);
                    L.setVisible(true);
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
