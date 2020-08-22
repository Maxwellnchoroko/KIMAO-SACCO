package dao;

import models.Netprofit;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNetprofitDao implements NetprofitDao {

    private final Sql2o sql2o;

    public Sql2oNetprofitDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Netprofit netprofit) {
        String sql = "INSERT INTO netprofit (date,) VALUES (:date)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(netprofit)
                    .executeUpdate()
                    .getKey();
            netprofit.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Netprofit> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM netprofit")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Netprofit.class);
        }
    }

    @Override
    public Netprofit findById(int id) {
        String sql = "SELECT * FROM netprofit  WHERE id =:id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Netprofit.class);

        }
    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE from netprofit WHERE id=:id";
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
        String sql = "DELETE from netprofit";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
