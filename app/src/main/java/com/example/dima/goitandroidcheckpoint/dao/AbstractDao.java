package com.example.dima.goitandroidcheckpoint.dao;

public interface AbstractDao<T> {

    void saveToDB(T t);
    boolean removeFromDB (T t);

}
