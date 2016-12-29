package com.example.dima.goitandroidcheckpoint.dao;

import com.example.dima.goitandroidcheckpoint.entity.Winner;

import java.util.ArrayList;
import java.util.List;

public class WinnerDaoImpl implements WinnerDao, AbstractDao<Winner> {

    private List<Winner> mWinners;

    public WinnerDaoImpl() {
        mWinners = new ArrayList<>();
    }

    @Override
    public void saveToDB(Winner winner) {
        mWinners.add(winner);
    }

    @Override
    public boolean removeFromDB(Winner winner) {
        return mWinners.remove(winner);
    }

    @Override
    public List<Winner> getAll() {
        return mWinners;
    }

    @Override
    public void cleanWinners() {
        mWinners.clear();
    }
}
