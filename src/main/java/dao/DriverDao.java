package dao;

import models.Driver;

import java.util.List;

public interface DriverDao {

    void add(Driver driver
    );

    List<Driver> getAll();
    List<Driver> getAllDriverByVehicle(int vehicleid);

    Driver findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
