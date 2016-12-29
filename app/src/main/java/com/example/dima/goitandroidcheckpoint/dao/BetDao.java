package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.Bet;
import com.example.dima.goitandroidcheckpoint.entity.User;

import java.util.List;

public interface BetDao{

    void cleanAllBet();

    List<Bet> getWinBet();

    List<Bet> getAllBetsForUser(User user);

}
