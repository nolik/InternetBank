package com.NovikIgor.dto;

import java.sql.Timestamp;

/**
 * Created by nolik on 03.11.16.
 */
public class Transaction {
    private int transactionID;
    private String operation;
    private int sumOfOperation;
    private Timestamp transactionTime;

    public Transaction() {
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getSumOfOperation() {
        return sumOfOperation;
    }

    public void setSumOfOperation(int sumOfOperation) {
        this.sumOfOperation = sumOfOperation;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", operation='" + operation + '\'' +
                ", sumOfOperation=" + sumOfOperation +
                ", transactionTime=" + transactionTime +
                '}';
    }
}
