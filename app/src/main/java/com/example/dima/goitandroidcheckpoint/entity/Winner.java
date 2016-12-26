package com.example.dima.goitandroidcheckpoint.entity;

public class Winner {

    private User user;
    private Bet bet;
    private int sum;

    public Winner(User user, Bet bet, int sum) {
        this.user = user;
        this.bet = bet;
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Winner winner = (Winner) o;

        if (sum != winner.sum) return false;
        if (user != null ? !user.equals(winner.user) : winner.user != null) return false;
        return bet != null ? bet.equals(winner.bet) : winner.bet == null;

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (bet != null ? bet.hashCode() : 0);
        result = 31 * result + sum;
        return result;
    }

    @Override
    public String toString() {
        return "Winner{" +
                "user=" + user +
                ", bet=" + bet +
                ", sum=" + sum +
                '}';
    }
}
