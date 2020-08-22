package dao;

import models.Owner;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oOwnerDao implements OwnerDao {

    @Override
    public List<Owner> getAllOwnerByVehicle(int vehicleid) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM user WHERE vehicleId = :vehicleId")
                    .addParameter("vehicleId", vehicleid)
                    .executeAndFetch(Owner.class);
        }

    }

    private final Sql2o sql2o;
    public Sql2oOwnerDao(Sql2o sql2o){
        this.sql2o =sql2o;
    }




    @Override
    public void add(Owner owner) {
        String sql = "INSERT INTO owner (name,nationalId,phoneNumber, type,emailAddress,dateOfRegistration)" +
                " VALUES (:name, :nationalId,:phoneNumber,:type,:emailAddress,:dateOfRegistration)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(owner)
                    .executeUpdate()
                    .getKey();
            owner.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Owner> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM owner")
                    .executeAndFetch(Owner.class);
        }
    }

    @Override
    public  Owner findById(int id){
        String sql = "SELECT * FROM owner  WHERE id =:id;";
        try(Connection con= sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Owner.class);

        }
    }



    @Override
    public void deleteById(int id) {
        String sql = "DELETE from owner WHERE id=:id";
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
        String sql = "DELETE from owner";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}


