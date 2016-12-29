package com.example.dima.goitandroidcheckpoint.dao;

import java.util.List;

public interface AbstractDao<T> {

    void saveToDB(T t);
    boolean removeFromDB (T t);
    List<T> getAll();

}
