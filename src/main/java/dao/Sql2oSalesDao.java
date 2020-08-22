package dao;

import models.Sales;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSalesDao implements SalesDao{
    @Override
    public List<Sales> getAllSalesByVehicle(int vehicleid) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM user WHERE vehicleId = :vehicleId")
                    .addParameter("vehicleId", vehicleid)
                    .executeAndFetch(Sales.class);
        }

    }

    private final Sql2o sql2o;
    public Sql2oSalesDao(Sql2o sql2o){
        this.sql2o =sql2o;
    }




    @Override
    public void add(Sales sales) {
        String sql = "INSERT INTO sales (name,nationalId,phoneNumber, type,emailAddress,dateOfRegistration)" +
                " VALUES (:name, :nationalId,:phoneNumber,:type,:emailAddress,:dateOfRegistration)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(sales)
                    .executeUpdate()
                    .getKey();
            sales.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Sales> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM sales")
                    .executeAndFetch(Sales.class);
        }
    }

    @Override
    public  Sales findById(int id){
        String sql = "SELECT * FROM sales  WHERE id =:id;";
        try(Connection con= sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Sales.class);

        }
    }



    @Override
    public void deleteById(int id) {
        String sql = "DELETE from sales WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void clearAll() {
        String sql = "DELETE from sales";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
