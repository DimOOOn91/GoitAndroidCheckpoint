package com.example.dima.goitandroidcheckpoint.entity;

public class Bet {

    private static long counter = 0;

    private long id;
    private User user;
    private int sum;
    private Horse horseNumber;
    private Position horsePosition;

    public Bet(User user, int sum, Horse horseNumber, Position horsePosition) {
        this.id = ++counter;
        this.user = user;
        this.sum = sum;
        this.horseNumber = horseNumber;
        this.horsePosition = horsePosition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Horse getHorseNumber() {
        return horseNumber;
    }

    public void setHorseNumber(Horse horseNumber) {
        this.horseNumber = horseNumber;
    }

    public Position getHorsePosition() {
        return horsePosition;
    }

    public void setHorsePosition(Position horsePosition) {
        this.horsePosition = horsePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (id != bet.id) return false;
        if (sum != bet.sum) return false;
        if (user != null ? !user.equals(bet.user) : bet.user != null) return false;
        if (horseNumber != bet.horseNumber) return false;
        return horsePosition == bet.horsePosition;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + sum;
        result = 31 * result + (horseNumber != null ? horseNumber.hashCode() : 0);
        result = 31 * result + (horsePosition != null ? horsePosition.hashCode() : 0);
        return result;
    }
}
