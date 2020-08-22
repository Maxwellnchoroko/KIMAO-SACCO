package dao;

import models.Agedvehicle;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

abstract class Sql20AgedvehicleDao implements AgedvehicleDao  {

    private final Sql2o sql2o;

    public Sql20AgedvehicleDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Agedvehicle agedvehicle) {
        String sql = "INSERT INTO agedvehicle (chassisNumber,regNumber,date,) VALUES (:chassisNumber,:regNumber,:date)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(agedvehicle)
                    .executeUpdate()
                    .getKey();
            agedvehicle.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Agedvehicle> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM agedvehicle")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Agedvehicle.class);
        }
    }

    @Override
    public Agedvehicle findById(int id) {
        String sql = "SELECT * FROM agedvehicle WHERE id =:id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Agedvehicle.class);

        }
    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE from agedvehicle WHERE id=:id";
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
        String sql = "DELETE from agedvehicle";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}

