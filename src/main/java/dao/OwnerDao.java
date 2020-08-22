package dao;



import models.Owner;

import java.util.List;

public interface OwnerDao {
    void add(Owner owner);

    List<Owner> getAll();
    public List<Owner> getAllOwnerByVehicle(int vehicleid);

    Owner findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
