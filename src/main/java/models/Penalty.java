package models;

import java.util.Objects;

public class Penalty {

    private int id;
    private String date;
    private int nationalId;
    private String amount;



    public Penalty( String date,int nationalId,String amount) {
        this. date = date;
        this.nationalId = nationalId;
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

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
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
        if (!(o instanceof Penalty)) return false;
        Penalty penalty = (Penalty) o;
        return getId() == penalty.getId() &&
                getNationalId() == penalty.getNationalId() &&
                Objects.equals(getDate(), penalty.getDate()) &&
                Objects.equals(getAmount(), penalty.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getNationalId(), getAmount());
    }
}
