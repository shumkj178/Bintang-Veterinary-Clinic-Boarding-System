package Classes;

import java.io.*;

public abstract class Pet implements Serializable {

    private String PetID;
    private String PetName;
    private int PetAge;
    private String PetType;
    private String PetSpecies;
    private String PetOwner;
    private String PetStatus;
    private String BoardingStatus;

    public Pet() {

    }

    public Pet(String PetID, String PetName, int PetAge, String PetType, String PetSpecies,
            String PetOwner, String PetStatus, String BoardingStatus) {
        this.PetID = PetID;
        this.PetName = PetName;
        this.PetAge = PetAge;
        this.PetType = PetType;
        this.PetSpecies = PetSpecies;
        this.PetOwner = PetOwner;
        this.PetStatus = PetStatus;
        this.BoardingStatus = BoardingStatus;
    }

    public void setPetID(String PetID) {
        this.PetID = PetID;
    }

    public String getPetID() {
        return PetID;
    }

    public void setPetName(String PetName) {
        this.PetName = PetName;
    }

    public String getPetName() {
        return PetName;
    }

    public void setPetAge(int PetAge) {
        this.PetAge = PetAge;
    }

    public int getPetAge() {
        return PetAge;
    }

    public void setPetType(String PetType) {
        this.PetType = PetType;
    }

    public String getPetType() {
        return PetType;
    }

    public void setPetSpecies(String PetSpecies) {
        this.PetSpecies = PetSpecies;
    }

    public String getPetSpecies() {
        return PetSpecies;
    }

    public void setPetOwner(String PetOwner) {
        this.PetOwner = PetOwner;
    }

    public String getPetOwner() {
        return PetOwner;
    }

    public void setPetStatus(String PetStatus) {
        this.PetStatus = PetStatus;
    }

    public String getPetStatus() {
        return PetStatus;
    }

    public void setBoardingStatus(String BoardingStatus) {
        this.BoardingStatus = BoardingStatus;
    }

    public String getBoardingStatus() {
        return BoardingStatus;
    }

}
