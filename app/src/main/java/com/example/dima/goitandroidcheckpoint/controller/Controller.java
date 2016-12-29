package com.example.dima.goitandroidcheckpoint.controller;

import android.text.TextUtils;

import com.example.dima.goitandroidcheckpoint.dao.BetDaoImpl;
import com.example.dima.goitandroidcheckpoint.dao.UserDaoImpl;
import com.example.dima.goitandroidcheckpoint.dao.WinnerDaoImpl;
import com.example.dima.goitandroidcheckpoint.entity.Bet;
import com.example.dima.goitandroidcheckpoint.entity.User;

import java.util.List;

public class Controller {
    private static Controller ourInstance = new Controller();

    private BetDaoImpl mBetDao;
    private UserDaoImpl mUserDao;
    private WinnerDaoImpl mWinnerDao;

    private Controller() {
        mBetDao = new BetDaoImpl();
        mUserDao = new UserDaoImpl();
        mWinnerDao = new WinnerDaoImpl();
    }

    public static Controller getInstance() {
        if (ourInstance == null) {
            ourInstance = new Controller();
        }
        return ourInstance;
    }

    public List<Bet> getAllBet() {
        return mBetDao.getAll();
    }

    public User getUserByEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return null;
        }
        return mUserDao.getUserByEmail(email);
    }

    public void saveBet(Bet bet) {
        mBetDao.saveToDB(bet);
    }

    public boolean userIsPresent(String email) {
        return mUserDao.isPresentUser(email);
    }

    public void addUser(User user) {
        mUserDao.saveToDB(user);
    }
}
