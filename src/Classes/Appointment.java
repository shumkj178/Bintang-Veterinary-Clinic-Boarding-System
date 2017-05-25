
package Classes;

import java.io.*;
import java.util.*;

public class Appointment implements Serializable{
    
    private String AppointmentDate;
    private String AppointmentTime;
    private Vet vet;
    private Customer customer;
    private String AppointmentID;
    private String PetAssigned;
    private String VetAssigned;
    private String Prognosis;
    private String Diagnosis;
    private int MedicalCharges;
    private String PetSeen;
    
    public Appointment(Vet vet, Customer customer){
        this.vet = vet;
        this.customer = customer;
    }
    
    public static void createFile() {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Appointment.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public static void populateList(List<Appointment> list) {
        try {
            FileInputStream inStream
                    = new FileInputStream("Appointment.dat");
            ObjectInputStream objectInputFile
                    = new ObjectInputStream(inStream);
            while (true) {
                list.add((Appointment) objectInputFile.readObject());
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public static void writeFile(List<Appointment> list) {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Appointment.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

            for (Appointment temp : list) {
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
        File file = new File("AppointmentID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        String PersonID = "APP" + String.format("%03d", x);
        return PersonID;
    }

    public void saveGeneratedID() throws IOException {
        int x;
        File file = new File("AppointmentID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        PrintWriter outputFile = new PrintWriter("AppointmentID.txt");
        outputFile.println(x);
        outputFile.close();
    }

    public String getAppointmentDate() {
        return AppointmentDate;
    }

    public void setAppointmentDate(String AppointmentDate) {
        this.AppointmentDate = AppointmentDate;
    }

    public String getAppointmentTime() {
        return AppointmentTime;
    }

    public void setAppointmentTime(String AppointmentTime) {
        this.AppointmentTime = AppointmentTime;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(String AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    public String getPetAssigned() {
        return PetAssigned;
    }

    public void setPetAssigned(String PetAssigned) {
        this.PetAssigned = PetAssigned;
    }

    public String getVetAssigned() {
        return VetAssigned;
    }

    public void setVetAssigned(String VetAssigned) {
        this.VetAssigned = VetAssigned;
    }

    public String getPrognosis() {
        return Prognosis;
    }

    public void setPrognosis(String Prognosis) {
        this.Prognosis = Prognosis;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }

    public int getMedicalCharges() {
        return MedicalCharges;
    }

    public void setCharges(int MedicalCharges) {
        this.MedicalCharges = MedicalCharges;
    }

    public String getPetSeen() {
        return PetSeen;
    }

    public void setPetSeen(String PetSeen) {
        this.PetSeen = PetSeen;
    }
}
