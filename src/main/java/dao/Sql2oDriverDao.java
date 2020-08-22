package dao;

import models.Driver;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDriverDao implements DriverDao {

    @Override
        public List<Driver> getAllDriverByVehicle(int vehicleid) {
            try (Connection con = sql2o.open()) {
                return con.createQuery("SELECT * FROM user WHERE vehicleId = :vehicleId")
                        .addParameter("vehicleId", vehicleid)
                        .executeAndFetch(Driver.class);
            }

        }

        private final Sql2o sql2o;
        public Sql2oDriverDao(Sql2o sql2o){
            this.sql2o =sql2o;
        }




        @Override
        public void add(Driver driver) {
            String sql = "INSERT INTO driver (name,nationalId,dateOfLease, dateOfReturn,chassisNumber,pay)" +
                    " VALUES (:name, :nationalId,:dateOfLease,:dateOfReturn,:chassisNumber,:pay)"; //if you change your model, be sure to update here as well!
            try (Connection con = sql2o.open()) {
                int id = (int) con.createQuery(sql, true)
                        .bind(driver)
                        .executeUpdate()
                        .getKey();
                driver.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
        }

        @Override
        public List<Driver> getAll() {
            try (Connection con = sql2o.open()) {
                return con.createQuery("SELECT * FROM driver")
                        .executeAndFetch(Driver.class);
            }
        }

        @Override
        public  Driver findById(int id){
            String sql = "SELECT * FROM driver  WHERE id =:id;";
            try(Connection con= sql2o.open()){
                return con.createQuery(sql)
                        .addParameter("id",id)
                        .executeAndFetchFirst(Driver.class);

            }
        }



        @Override
        public void deleteById(int id) {
            String sql = "DELETE from driver WHERE id=:id";
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
            String sql = "DELETE from driver";
            try (Connection con = sql2o.open()) {
                con.createQuery(sql).executeUpdate();
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
        }
    }



