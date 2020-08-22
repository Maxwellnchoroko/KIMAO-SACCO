package dao;



import models.Sales;

import java.util.List;

public interface SalesDao {
    void add(Sales sales);

    List<Sales> getAll();
    public List<Sales> getAllSalesByVehicle(int vehicleid);

    Sales findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
