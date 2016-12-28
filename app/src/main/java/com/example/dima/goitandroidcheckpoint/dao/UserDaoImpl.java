package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.Bet;
import com.example.dima.goitandroidcheckpoint.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl ourInstance = null;

    private List<User> mUsers;

    private UserDaoImpl() {
        mUsers = new ArrayList<>();
    }

    public static UserDaoImpl getInstance() {
        if (ourInstance == null) {
            ourInstance = new UserDaoImpl();
        }
        return ourInstance;
    }

    @Override
    public List<Bet> getAllBets(User user) {
        return null;
    }

    @Override
    public List<User> getWinners() {
        return null;
    }

    @Override
    public int getThePrize(User user, Bet bet) {
        return 0;
    }

    @Override
    public User saveToDB(User user) {

        for (int i = 0; i < mUsers.size(); i++) {
            User u = mUsers.get(i);
            if (u.getEmail().equals(user.getEmail())) {
                return null;
            }
        }
        mUsers.add(user);
        return user;
    }

    @Override
    public boolean removeFromDB(User user) {
        return mUsers.remove(user);
    }

    public List<User> getAllUsers() {
        return mUsers;
    }
}
