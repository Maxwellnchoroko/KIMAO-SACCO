package dao;

import models.Vehicle;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oVehicleDao  implements VehicleDao{
    private final Sql2o sql2o;
    public Sql2oVehicleDao(Sql2o sql2o){
        this.sql2o =sql2o;
    }

    @Override
    public void add(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (modelName,age, color, dateOfPurchase, ownerId,purchasePrice,currentPrice," +
                "chassisNumber,driverId, mechanicId) VALUES (:modelName,:age, :color, :dateOfPurchase, :ownerId," +
                ":purchasePrice,:currentPrice,:chassisNumber,:driverId, :mechanicId)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(vehicle)
                    .executeUpdate()
                    .getKey();
            vehicle.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Vehicle> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM vehicle")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Vehicle.class);
        }
    }
    @Override
    public  Vehicle findById(int id){
        String sql = "SELECT * FROM vehicle  WHERE id =:id;";
        try(Connection con= sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Vehicle.class);

        }
    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE from vehicle WHERE id=:id";
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
        String sql = "DELETE from vehicle";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}

