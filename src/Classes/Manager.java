package Classes;

import java.util.*;
import java.io.*;

public class Manager extends Person implements Serializable {

    public Manager() {

    }

    public static void createFile() {
        try {
            FileOutputStream outStream
                    = new FileOutputStream("Manager.dat");
            ObjectOutputStream objectOutputFile
                    = new ObjectOutputStream(outStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void populateList(List<Manager> list) {
        try {           
            FileInputStream inStream 
                    = new FileInputStream("Manager.dat");
            ObjectInputStream objectInputFile 
                    = new ObjectInputStream(inStream);
            while (true){
                list.add((Manager) objectInputFile.readObject());
            }
            
        } catch (Exception e) {

        }
    }

}
