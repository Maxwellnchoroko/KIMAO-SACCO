package models;

import java.util.Objects;

public class Sales {

    private int id;
    private String date;
    private int vehicleId;
    private String chassisNumber;
    private String amount;



    public Sales( String date,int vehicleId,String chassisNumber,String amount) {
        this. date = date;
        this.chassisNumber= chassisNumber;
        this.vehicleId = vehicleId;
        this.amount = amount;

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

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sales)) return false;
        Sales sales = (Sales) o;
        return getId() == sales.getId() &&
                getVehicleId() == sales.getVehicleId() &&
                Objects.equals(getDate(), sales.getDate()) &&
                Objects.equals(getChassisNumber(), sales.getChassisNumber()) &&
                Objects.equals(getAmount(), sales.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getVehicleId(), getChassisNumber(), getAmount());
    }
}
