package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao, AbstractDao<User> {

    private List<User> mUsers;

    public UserDaoImpl() {
        mUsers = new ArrayList<>();
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : mUsers) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isPresentUser(String email) {
        return getUserByEmail(email) != null;
    }

    @Override
    public void saveToDB(User user) {
        mUsers.add(user);
    }

    @Override
    public boolean removeFromDB(User user) {
        return mUsers.remove(user);
    }

    @Override
    public List<User> getAll() {
        return mUsers;
    }

}
