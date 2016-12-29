package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.User;

public interface UserDao {

    User getUserByEmail(String email);

    boolean isPresentUser(String email);

}
