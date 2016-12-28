package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.Bet;

import java.util.ArrayList;
import java.util.List;

public class BetDaoImpl implements BetDao {

    private static BetDaoImpl ourInstance = null;

    private List<Bet> mBets;

    private BetDaoImpl() {
        mBets = new ArrayList<>();
    }

    public static BetDaoImpl getInstance() {
        if (ourInstance == null) {
            ourInstance = new BetDaoImpl();
        }
        return ourInstance;
    }

    @Override
    public void cleanAllBet() {
        mBets.clear();
    }

    @Override
    public List<Bet> getWinnerBet() {
        //TODO Logic
        return null;
    }

    @Override
    public Bet saveToDB(Bet bet) {
        mBets.add(bet);
        return bet;
    }

    @Override
    public boolean removeFromDB(Bet bet) {
        return mBets.remove(bet);
    }

    public List<Bet> getBets() {
        return mBets;
    }
}
