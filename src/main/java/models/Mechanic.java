package models;

import java.util.Objects;

public class Mechanic {
    private int id;
    private String name;
    private int nationalId;
    private int phoneNumber;
    private String chassisNumber;
    private String cost;



    public Mechanic( String name,int nationalId,String chassisNumber,int phoneNumber,String cost) {
        this.name = name;
        this. nationalId = nationalId;
        this.chassisNumber= chassisNumber;
        this.phoneNumber = phoneNumber;
        this.cost = cost;

    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mechanic)) return false;
        Mechanic mechanic = (Mechanic) o;
        return getId() == mechanic.getId() &&
                getNationalId() == mechanic.getNationalId() &&
                getPhoneNumber() == mechanic.getPhoneNumber() &&
                Objects.equals(getName(), mechanic.getName()) &&
                Objects.equals(getChassisNumber(), mechanic.getChassisNumber()) &&
                Objects.equals(getCost(), mechanic.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNationalId(), getPhoneNumber(), getChassisNumber(), getCost());
    }
}
