package Classes;

import java.io.*;
import java.util.*;

public class Receptionist extends Person implements Serializable {

    private String RecPassword;

    public Receptionist() {

    }

    public void setRecPassword(String RecPassword) {
        this.RecPassword = RecPassword;
    }

    public String getRecPassword() {
        return RecPassword;
    }

    public static void createFile() {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Receptionist.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

        } catch (EOFException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public static void populateList(List<Receptionist> list) {
        try {
            FileInputStream inStream
                    = new FileInputStream("Receptionist.dat");
            ObjectInputStream objectInputFile
                    = new ObjectInputStream(inStream);
            while (true) {
                list.add((Receptionist) objectInputFile.readObject());
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void writeFile(List<Receptionist> list) {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Receptionist.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

            for (Receptionist temp : list) {
                objectOutputFile.writeObject(temp);
            }
            objectOutputFile.close();

        } catch (EOFException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public String generateID() throws IOException {
        int x;
        File file = new File("ReceptionistID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        String PersonID = "RECEP" + String.format("%03d", x);
        return PersonID;
    }

    public void saveGeneratedID() throws IOException {
        int x;
        File file = new File("ReceptionistID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        PrintWriter outputFile = new PrintWriter("ReceptionistID.txt");
        outputFile.println(x);
        outputFile.close();
    }
}
