package models;

import java.util.Objects;

public class Agedvehicle {

    private int id;
    private String date;
    private String regNumber;
    private String chassisNumber;


    public Agedvehicle(String date, String chassisNumber, String regNumber) {
        this.date = date;
        this.chassisNumber = chassisNumber;
        this.regNumber = regNumber;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agedvehicle)) return false;
        Agedvehicle that = (Agedvehicle) o;
        return getId() == that.getId() &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getRegNumber(), that.getRegNumber()) &&
                Objects.equals(getChassisNumber(), that.getChassisNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getRegNumber(), getChassisNumber());
    }
}