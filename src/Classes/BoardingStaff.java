package Classes;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoardingStaff extends Person implements Serializable {

    private String BSPassword;

    public BoardingStaff() {

    }

    public void setBSPassword(String BSPassword) {
        this.BSPassword = BSPassword;
    }

    public String getBSPassword() {
        return BSPassword;
    }

    public static void createFile() {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("BoardingStaff.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (IOException ex) {

        }
    }

    public static void populateList(List<BoardingStaff> list) {
        try {
            FileInputStream inStream
                    = new FileInputStream("BoardingStaff.dat");
            ObjectInputStream objectInputFile
                    = new ObjectInputStream(inStream);
            while (true) {
                list.add((BoardingStaff) objectInputFile.readObject());
            }
        } catch (EOFException e) {

        } catch (FileNotFoundException ex) {

        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void writeFile(List<BoardingStaff> list) {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("BoardingStaff.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

            for (BoardingStaff temp : list) {
                objectOutputFile.writeObject(temp);
            }
            objectOutputFile.close();

        } catch (EOFException e) {

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public String generateID() throws IOException {
        int x;
        File file = new File("BoardingStaffID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        String PersonID = "BS" + String.format("%03d", x);
        return PersonID;
    }

    public void saveGeneratedID() throws IOException {
        int x;
        File file = new File("BoardingStaffID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        PrintWriter outputFile = new PrintWriter("BoardingStaffID.txt");
        outputFile.println(x);
        outputFile.close();
    }
}
