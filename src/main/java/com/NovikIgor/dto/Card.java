package com.NovikIgor.dto;

import java.math.BigDecimal;

/**
 * Created by nolik on 23.10.16.
 */
public class Card {
    private int cardNumber;
    private BigDecimal sum;
    private String user;
    private String currency;

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
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
