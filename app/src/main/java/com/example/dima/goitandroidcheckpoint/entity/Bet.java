package com.example.dima.goitandroidcheckpoint.entity;

public class Bet {

    private String user;
    private int sum;
    private Horse horseNumber;
    private String horsePosition;

    public Bet(String user, int sum, Horse horseNumber, String horsePosition) {
        this.user = user;
        this.sum = sum;
        this.horseNumber = horseNumber;
        this.horsePosition = horsePosition;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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

    public String getHorsePosition() {
        return horsePosition;
    }

    public void setHorsePosition(String horsePosition) {
        this.horsePosition = horsePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (sum != bet.sum) return false;
        if (user != null ? !user.equals(bet.user) : bet.user != null) return false;
        if (horseNumber != bet.horseNumber) return false;
        return horsePosition != null ? horsePosition.equals(bet.horsePosition) : bet.horsePosition == null;

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + sum;
        result = 31 * result + (horseNumber != null ? horseNumber.hashCode() : 0);
        result = 31 * result + (horsePosition != null ? horsePosition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "user='" + user + '\'' +
                ", sum=" + sum +
                ", horseNumber=" + horseNumber +
                ", horsePosition='" + horsePosition + '\'' +
                '}';
    }
}
