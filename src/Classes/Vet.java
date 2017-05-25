package Classes;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vet extends Person implements Serializable {

    private String Expertise;
    private String Expertise2;
    private String VetPassword;

    public Vet() {

    }

    public void setExpertise(String Expertise) {
        this.Expertise = Expertise;
    }

    public String getExpertise() {
        return Expertise;
    }

    public void setExpertise2(String Expertise2) {
        this.Expertise2 = Expertise2;
    }

    public String getExpertise2() {
        return Expertise2;
    }

    public void setVetPassword(String VetPassword) {
        this.VetPassword = VetPassword;
    }

    public String getVetPassword() {
        return VetPassword;
    }

    public static void createFile() {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Vet.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }

    public static void populateList(List<Vet> list) {
        try {
            FileInputStream inStream
                    = new FileInputStream("Vet.dat");
            ObjectInputStream objectInputFile
                    = new ObjectInputStream(inStream);
            while (true) {
                list.add((Vet) objectInputFile.readObject());
            }
        } catch (EOFException e) {

        } catch (FileNotFoundException ex) {

        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void writeFile(List<Vet> list) {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Vet.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

            for (Vet temp : list) {
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
        File file = new File("VetID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        String PersonID = "VET" + String.format("%03d", x);
        return PersonID;
    }

    public void saveGeneratedID() throws IOException {
        int x;
        File file = new File("VetID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        PrintWriter outputFile = new PrintWriter("VetID.txt");
        outputFile.println(x);
        outputFile.close();
    }
}
