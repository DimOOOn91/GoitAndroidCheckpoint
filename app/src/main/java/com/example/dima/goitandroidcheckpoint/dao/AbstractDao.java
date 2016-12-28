package com.example.dima.goitandroidcheckpoint.dao;

public interface AbstractDao<T> {

    T saveToDB(T t);
    boolean removeFromDB (T t);

}
