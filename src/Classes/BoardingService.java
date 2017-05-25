package Classes;

import java.io.*;
import java.util.*;

public class BoardingService implements Serializable {

    private String BoardingServiceID;
    private Customer customer;
    private String BoardDate;
    private String CheckOutDate;
    private String LastFed;

    public BoardingService(Customer customer) {
        this.customer = customer;
    }

    public static void createFile() {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("BoardingService.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

        } catch (EOFException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public static void populateList(List<BoardingService> list) {
        try {
            FileInputStream inStream
                    = new FileInputStream("BoardingService.dat");
            ObjectInputStream objectInputFile
                    = new ObjectInputStream(inStream);
            while (true) {
                list.add((BoardingService) objectInputFile.readObject());
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    public static void writeFile(List<BoardingService> list) {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("BoardingService.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

            for (BoardingService temp : list) {
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
        File file = new File("BoardingServiceID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        String PersonID = "BDSV" + String.format("%03d", x);
        return PersonID;
    }

    public void saveGeneratedID() throws IOException {
        int x;
        File file = new File("BoardingServiceID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        PrintWriter outputFile = new PrintWriter("BoardingServiceID.txt");
        outputFile.println(x);
        outputFile.close();
    }

    public String getBoardingServiceID() {
        return BoardingServiceID;
    }

    public void setBoardingServiceID(String BoardingServiceID) {
        this.BoardingServiceID = BoardingServiceID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getLastFed() {
        return LastFed;
    }

    public void setLastFed(String LastFed) {
        this.LastFed = LastFed;
    }

    public String getBoardDate() {
        return BoardDate;
    }

    public void setBoardDate(String BoardDate) {
        this.BoardDate = BoardDate;
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String CheckOutDate) {
        this.CheckOutDate = CheckOutDate;
    }
}
