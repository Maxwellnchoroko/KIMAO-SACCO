package dao;


import models.Mechanic;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oMechanicDao implements MechanicDao {
    @Override
    public List<Mechanic> getAllMechanicByVehicle(int vehicleid) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM user WHERE vehicleId = :vehicleId")
                    .addParameter("vehicleId", vehicleid)
                    .executeAndFetch(Mechanic.class);
        }

    }

    private final Sql2o sql2o;
    public Sql2oMechanicDao(Sql2o sql2o){
        this.sql2o =sql2o;
    }




    @Override
    public void add(Mechanic mechanic) {
        String sql = "INSERT INTO mechanic (name,nationalId,phoneNumber, cost,chassisNumber)" +
                " VALUES (:name, :nationalId,:phoneNumber,:cost,:chassisNumber,:pay)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(mechanic)
                    .executeUpdate()
                    .getKey();
            mechanic.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Mechanic> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM mechanic")
                    .executeAndFetch(Mechanic.class);
        }
    }

    @Override
    public  Mechanic findById(int id){
        String sql = "SELECT * FROM mechanic  WHERE id =:id;";
        try(Connection con= sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Mechanic.class);

        }
    }



    @Override
    public void deleteById(int id) {
        String sql = "DELETE from mechanic WHERE id=:id";
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
        String sql = "DELETE from mechanic";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
