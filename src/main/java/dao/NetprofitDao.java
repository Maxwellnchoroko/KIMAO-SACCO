package dao;

import models.Netprofit;

import java.util.List;

public interface NetprofitDao {
    void add(Netprofit netprofit);

    List<Netprofit> getAll();

    Netprofit findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
