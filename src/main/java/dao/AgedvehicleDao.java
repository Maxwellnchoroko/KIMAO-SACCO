package dao;

import models.Agedvehicle;


import java.util.List;

public interface AgedvehicleDao {
    void add(Agedvehicle agedvehicle);

    List<Agedvehicle> getAll();

    Agedvehicle findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
