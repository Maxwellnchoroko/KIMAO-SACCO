import com.google.gson.Gson;
import dao.*;
import models.ApiException;
import models.DB;
import models.Driver;
import models.Vehicle;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");


        Sql2oVehicleDao VehicleDao;
        Sql2oMechanicDao MechanicDao;
        Sql2oDriverDao DriverDao;
        Sql2oOwnerDao OwnerDao;
        Sql2oSalesDao SalesDao;
//        Sql2oPenaltyDao PenaltyDao;
        Sql2oNetprofitDao NetprofitDao;
//        Sql2oAgedvehicleDao agedvehicleDao;
        Connection conn;
        Gson gson = new Gson();


        Sql2o sql2o = DB.sql2o;
        VehicleDao = new Sql2oVehicleDao(sql2o);
        MechanicDao = new Sql2oMechanicDao(sql2o);
        DriverDao = new Sql2oDriverDao(sql2o);
        OwnerDao = new Sql2oOwnerDao(sql2o);
        MechanicDao = new Sql2oMechanicDao(sql2o);
//        DriverDao = new Sql2oNewDao(sql2o);
        conn = sql2o.open();

        post("/driver/new", "application/json", (req, res) -> {
            Driver driver = gson.fromJson(req.body(), Driver.class);
            DriverDao.add(driver);
            res.status(201);
            return gson.toJson(driver);
        });

        //READ
        get("/driver", "application/json", (req, res) -> {
            System.out.println(DriverDao.getAll());

            if(DriverDao.getAll().size() > 0){
                return gson.toJson(DriverDao.getAll());
            }

            else {
                return "{\"message\":\"I'm sorry, but no restaurants are currently listed in the database.\"}";
            }

        });

        get("/vehicle/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int vehicleId = Integer.parseInt(req.params("id"));
            return gson.toJson(VehicleDao.findById(vehicleId));
        });

        get("/vehicle/:id/driver", "application/json", (req, res) -> {
            int vehicleId = Integer.parseInt(req.params("id"));

            Vehicle VehicleToFind = VehicleDao.findById(vehicleId);
            List<Driver> allDrivers;

            if (VehicleToFind == null){
                throw new ApiException(404, String.format("No departments with the id: \"%s\" exists", req.params("id")));
            }

            allDrivers = DriverDao.getAllDriverByVehicle(vehicleId);

            return gson.toJson(allDrivers);
        });

        get("/users", "application/json", (req, res) -> {
            return gson.toJson(VehicleDao.getAll());
        });


        //CREATE

        post("/vehicle/new", "application/json", (req, res) -> {
            Vehicle vehicle = gson.fromJson(req.body(), Vehicle.class);
            VehicleDao.add(vehicle);
            res.status(201);
            return gson.toJson(vehicle);
        });


        get("/forms",(request, response) -> {
            Map<String,Object> model =new HashMap<>();
            return  new ModelAndView(model,"forms.hbs");
        }, new HandlebarsTemplateEngine());



    }
}





