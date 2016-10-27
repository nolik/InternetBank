package com.NovikIgor.dto;

/**
 * Created by nolik on 23.10.16.
 */
public class Card {
    private int cardNumber;
    private int sum;
    private String user;
    private String currency;

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", sum=" + sum +
                ", user='" + user + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
