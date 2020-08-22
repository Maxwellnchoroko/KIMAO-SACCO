package models;

import java.util.Objects;

public class Netprofit {

    private int id;
    private String date;



    public Netprofit( String date) {
        this. date = date;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Netprofit)) return false;
        Netprofit netprofit = (Netprofit) o;
        return getId() == netprofit.getId() &&
                Objects.equals(getDate(), netprofit.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
