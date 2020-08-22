package dao;



import models.Mechanic;

import java.util.List;

public interface MechanicDao {

    void add(Mechanic mechanic);

    List<Mechanic> getAll();
    public List<Mechanic> getAllMechanicByVehicle(int vehicleid);

    Mechanic findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
