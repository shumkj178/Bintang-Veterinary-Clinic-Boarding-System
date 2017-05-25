package Classes;

import java.io.*;

public abstract class Person implements Serializable {

    private String ID;
    private String FirstName;
    private String LastName;
    private String Address;
    private String Gender;
    private int Age;
    private String ContactNumber;
    private String Job;

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getGender() {
        return Gender;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getAge() {
        return Age;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public String getJob() {
        return Job;
    }

}
