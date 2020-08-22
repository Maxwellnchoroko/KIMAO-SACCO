package dao;
import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
//import org.sql2o.*;





public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/kimao_sacco_test", "roselyne","moraa@2018");
    }
    @Override
    protected void after(){
        try(Connection con= DB.sql2o.open()){
            String deleteVehicleQuery ="DELETE FROM vehicle*;";
            String deleteOwnerQuery="DELETE FROM owner;";
            String deleteMechanicQuery="DELETE FROM mechanic;";
            String deleteDriverQuery ="DELETE FROM driver*;";
            String deleteSalesQuery="DELETE FROM sales;";
            String deletePenaltyQuery="DELETE FROM penalty;";
            String deleteNetprofitQuery="DELETE FROM netprofit;";
            String deleteAgedvehicleQuery="DELETE FROM agedvehicle;";
            con.createQuery(deleteVehicleQuery).executeUpdate();
            con.createQuery(deleteOwnerQuery).executeUpdate();
            con.createQuery(deleteMechanicQuery).executeUpdate();
            con.createQuery(deleteDriverQuery).executeUpdate();
            con.createQuery(deleteSalesQuery).executeUpdate();
            con.createQuery(deletePenaltyQuery).executeUpdate();
            con.createQuery(deleteNetprofitQuery).executeUpdate();
            con.createQuery(deleteAgedvehicleQuery).executeUpdate();
        }
    }


}


