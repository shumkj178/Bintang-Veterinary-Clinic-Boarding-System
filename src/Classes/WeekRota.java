package Classes;

import java.io.*;
import java.util.*;

public class WeekRota implements Serializable {

    private String WeekRotaID;
    private int WeekRotaMonth;
    private String[]Sunday = new String[3];
    private String[] Monday = new String[3];
    private String[] Tuesday = new String[3];
    private String[] Wednesday = new String[3];
    private String[] Thursday = new String[3];
    private String[] Friday = new String[3];
    private String[] Saturday = new String[3];

    public WeekRota() {

    }

    public static void createFile() {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("WeekRota.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public static void populateList(List<WeekRota> list) {
        try {
            FileInputStream inStream
                    = new FileInputStream("WeekRota.dat");
            ObjectInputStream objectInputFile
                    = new ObjectInputStream(inStream);
            while (true) {
                list.add((WeekRota) objectInputFile.readObject());
            }
        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public static void writeFile(List<WeekRota> list) {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("WeekRota.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

            for (WeekRota temp : list) {
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
        File file = new File("WeekRotaID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        String PersonID = "WR" + String.format("%03d", x);
        return PersonID;
    }

    public void saveGeneratedID() throws IOException {
        int x;
        File file = new File("WeekRotaID.txt");
        Scanner inputFile = new Scanner(file);
        x = Integer.parseInt(inputFile.nextLine());
        inputFile.close();

        x++;

        PrintWriter outputFile = new PrintWriter("WeekRotaID.txt");
        outputFile.println(x);
        outputFile.close();
    }

    public String getWeekRotaID() {
        return WeekRotaID;
    }

    public void setWeekRotaID(String WeekRotaID) {
        this.WeekRotaID = WeekRotaID;
    }

    public int getWeekRotaMonth() {
        return WeekRotaMonth;
    }

    public void setWeekRotaMonth(int WeekRotaMonth) {
        this.WeekRotaMonth = WeekRotaMonth;
    }

    public String[] getSunday() {
        return Sunday;
    }

    public void setSunday(String[] Sunday) {
        this.Sunday = Sunday;
    }

    public String[] getMonday() {
        return Monday;
    }

    public void setMonday(String[] Monday) {
        this.Monday = Monday;
    }

    public String[] getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String[] Tuesday) {
        this.Tuesday = Tuesday;
    }

    public String[] getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String[] Wednesday) {
        this.Wednesday = Wednesday;
    }

    public String[] getThursday() {
        return Thursday;
    }

    public void setThursday(String[] Thursday) {
        this.Thursday = Thursday;
    }

    public String[] getFriday() {
        return Friday;
    }

    public void setFriday(String[] Friday) {
        this.Friday = Friday;
    }

    public String[] getSaturday() {
        return Saturday;
    }

    public void setSaturday(String[] Saturday) {
        this.Saturday = Saturday;
    }

}
