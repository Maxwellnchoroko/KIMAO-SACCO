package models;

import java.util.Objects;

public class Driver {
    private int id;
    private String name;
    private int nationalId;
    private String dateOfLease;
    private String dateOfReturn;
    private String chassisNumber;
    private String pay;



    public Driver( String name,int nationalId,String dateOfLease, String dateOfReturn,String chassisNumber, String pay) {
        this.name = name;
        this. nationalId = nationalId;
        this.dateOfReturn = dateOfReturn;
        this.dateOfLease = dateOfLease;
        this.chassisNumber = chassisNumber;
        this.pay = pay;

    }

    public String getName() {
        return name;
    }

    public String getDateOfLease() {
        return dateOfLease;
    }

    public void setDateOfLease(String dateOfLease) {
        this.dateOfLease = dateOfLease;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver that = (Driver) o;
        return getName() == that.getName() &&
                getId() == that.getId() &&
                getNationalId()== that.getNationalId() &&
                getChassisNumber().equals(that.getChassisNumber()) &&
                getPay().equals(that.getPay()) &&
                getDateOfLease().equals(that.getDateOfLease()) &&
                getDateOfReturn().equals(that.getDateOfReturn()) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNationalId(), getDateOfLease(),getDateOfReturn(),
                getChassisNumber(), getPay(), getId());
    }
}
