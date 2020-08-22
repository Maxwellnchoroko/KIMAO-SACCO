package dao;


import models.Penalty;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

abstract class Sql2oPenaltyDao implements PenaltyDao{

    @Override
    public List<Penalty> getAllPenaltyByDriver(int driverid) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM user WHERE driverId = :driverId")
                    .addParameter("driverId", driverid)
                    .executeAndFetch(Penalty.class);
        }

    }

    private final Sql2o sql2o;
    public Sql2oPenaltyDao(Sql2o sql2o){
        this.sql2o =sql2o;
    }




    @Override
    public void add(Penalty penalty) {
        String sql = "INSERT INTO penalty (nationalId,amount,date)" +
                " VALUES (nationalId,amount,date)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(penalty)
                    .executeUpdate()
                    .getKey();
            penalty.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Penalty> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM penalty")
                    .executeAndFetch(Penalty.class);
        }
    }

    @Override
    public  Penalty findById(int id){
        String sql = "SELECT * FROM penalty  WHERE id =:id;";
        try(Connection con= sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Penalty.class);

        }
    }



    @Override
    public void deleteById(int id) {
        String sql = "DELETE from penalty WHERE id=:id";
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
        String sql = "DELETE from penalty";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
