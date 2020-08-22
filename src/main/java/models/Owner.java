package models;

import java.util.Objects;

public class Owner {

    private int id;
    private String name;
    private int nationalId;
    private String emailAddress;
    private String dateOfRegistration;
    private int phoneNumber;
    private String type;



    public Owner( String name,int nationalId,String emailAddress,  String dateOfRegistration,int phoneNumber,String type) {
        this.name = name;
        this. nationalId = nationalId;
        this.emailAddress = emailAddress;
        this.dateOfRegistration = dateOfRegistration;
        this.phoneNumber = phoneNumber;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return getId() == owner.getId() &&
                getNationalId() == owner.getNationalId() &&
                getPhoneNumber() == owner.getPhoneNumber() &&
                Objects.equals(getName(), owner.getName()) &&
                Objects.equals(getEmailAddress(), owner.getEmailAddress()) &&
                Objects.equals(getDateOfRegistration(), owner.getDateOfRegistration()) &&
                Objects.equals(getType(), owner.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNationalId(), getEmailAddress(), getDateOfRegistration(), getPhoneNumber(), getType());
    }
}
