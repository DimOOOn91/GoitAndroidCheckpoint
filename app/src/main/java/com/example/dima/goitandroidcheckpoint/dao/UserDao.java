package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.Bet;
import com.example.dima.goitandroidcheckpoint.entity.User;

import java.util.List;

public interface UserDao extends AbstractDao<User> {

    List<Bet> getAllBets(User user);
    List<User> getWinners();
    int getThePrize(User user, Bet bet);

}
