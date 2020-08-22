package dao;

import models.Vehicle;

import java.util.List;

public interface VehicleDao {

        void add(Vehicle vehicle);

        List<Vehicle> getAll();

        Vehicle findById(int id);

        //delete
        void deleteById(int id);
        void clearAll();
    }



