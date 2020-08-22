package dao;
import models.Penalty;

import java.util.List;

public interface PenaltyDao {
    void add(Penalty penalty
);

    List<Penalty> getAll();
    List<Penalty> getAllPenaltyByDriver(int driverid);

    Penalty findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
