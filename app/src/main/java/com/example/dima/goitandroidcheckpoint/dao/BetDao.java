package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.Bet;

import java.util.List;

public interface BetDao extends AbstractDao<Bet> {

    void cleanAllBet();
    List<Bet> getWinnerBet();


}
