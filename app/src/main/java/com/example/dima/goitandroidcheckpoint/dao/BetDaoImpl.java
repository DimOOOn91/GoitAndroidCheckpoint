package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.Bet;
import com.example.dima.goitandroidcheckpoint.entity.User;

import java.util.ArrayList;
import java.util.List;

public class BetDaoImpl implements BetDao, AbstractDao<Bet>  {

    private List<Bet> mBets;

    public BetDaoImpl() {
        mBets = new ArrayList<>();
    }

    @Override
    public void cleanAllBet() {
        mBets.clear();
    }

    @Override
    public List<Bet> getWinBet() {
        //TODO Logic
        return null;
    }

    @Override
    public List<Bet> getAllBetsForUser(User user) {
        return null;
    }

    @Override
    public void saveToDB(Bet bet) {
        mBets.add(bet);
    }

    @Override
    public boolean removeFromDB(Bet bet) {
        return mBets.remove(bet);
    }

    @Override
    public List<Bet> getAll() {
        return mBets;
    }

}
