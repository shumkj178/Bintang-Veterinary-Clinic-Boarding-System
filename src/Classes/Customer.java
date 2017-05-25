package Classes;

import java.util.*;
import java.io.*;

public class Customer extends Person implements Serializable {

    private Pet pet;

    public Customer() {

    }

    public Customer(String x) {
        if (x.equals("Mammals")) {
            pet = new Mammals();
        } else if (x.equals("Reptiles")) {
            pet = new Reptiles();
        } else if (x.equals("Birds")) {
            pet = new Birds();
        } else if (x.equals("Amphibians")) {
            pet = new Amphibians();
        } else if (x.equals("Fish")) {
            pet = new Fish();
        }
    }

    public Pet getPet() {
        return pet;
    }

    public static void createFile() {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Customer.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public static void populateList(List<Customer> list) {
        try {
            FileInputStream inStream
                    = new FileInputStream("Customer.dat");
            ObjectInputStream objectInputFile
                    = new ObjectInputStream(inStream);
            while (true) {
                list.add((Customer) objectInputFile.readObject());
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public static void writeFile(List<Customer> list) {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Customer.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

            for (Customer temp : list) {
                objectOutputFile.writeObject(temp);
            }
            objectOutputFile.close();

        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public String generateID() throws IOException {
        int x;
        File file = new File("CustomerID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        String PersonID = "CUST" + String.format("%03d", x);
        return PersonID;
    }

    public void saveGeneratedID() throws IOException {
        int x;
        File file = new File("CustomerID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        PrintWriter outputFile = new PrintWriter("CustomerID.txt");
        outputFile.println(x);
        outputFile.close();
    }

    public String generatePetID() throws IOException {
        int x;
        File file = new File("PetID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        String PersonID = "PET" + String.format("%03d", x);
        return PersonID;
    }

    public void saveGeneratedPetID() throws IOException {
        int x;
        File file = new File("PetID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        PrintWriter outputFile = new PrintWriter("PetID.txt");
        outputFile.println(x);
        outputFile.close();
    }
}
