package models;

import java.util.Objects;

public class Vehicle {
    private int id;
    private String modelName;
    private int age;
    private String color;
    private String dateOfPurchase;
    private int ownerId;
    private String purchasePrice;
    private String currentPrice;
    private String chassisNumber;
    private int driverId;
    private int mechanicId;


    public Vehicle(String modelName,int age, String color, String dateOfPurchase, int ownerId,String purchasePrice,String currentPrice,String chassisNumber,int driverId,int mechanicId) {
        this.modelName = modelName;
        this.age = age;
        this.color = color;
        this.dateOfPurchase = dateOfPurchase;
        this.ownerId = ownerId;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
        this.chassisNumber = chassisNumber;
        this.driverId = driverId;
        this.mechanicId = mechanicId;
    }

    public String getModelName() {
        return modelName;
    }

    public int getAge() {
        return age;
    }


    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String getColor() {
        return color;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setModelName(String modelName) {

        this.modelName = modelName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Vehicle() {
        super();
    }

    public int getOwnerId() {
        return ownerId;

        }





        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }




    public void setColor(String color) {
        this.color = color;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }


    public String getCurrentPrice() {
        return currentPrice;
    }



    public String getChassisNumber() {
        return chassisNumber;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public int getDriverId() {
        return driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle that = (Vehicle) o;
        return getModelName() == that.getModelName() &&
                getId() == that.getId() &&
                getMechanicId()== that.getMechanicId() &&
                getOwnerId()== that.getOwnerId() &&
                getDriverId()== that.getDriverId() &&
                getAge()== that.getAge() &&
                getChassisNumber().equals(that.getChassisNumber()) &&
                getPurchasePrice().equals(that.getPurchasePrice()) &&
                getColor().equals(that.getColor()) &&
                getDateOfPurchase().equals(that.getDateOfPurchase()) &&
                getCurrentPrice().equals(that.getCurrentPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModelName(), getMechanicId(), getOwnerId(),getDriverId(), getAge(),
                getChassisNumber(), getPurchasePrice(), getColor(),getDateOfPurchase(), getCurrentPrice(),getId());
    }

}