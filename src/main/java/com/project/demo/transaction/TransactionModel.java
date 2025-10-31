package com.project.demo.transaction;

public class TransactionModel {

    private long transactionId;
    private long transactionTypeId;
    private double amount;
    private double prevAmount;
    private double currAmount;
    private String description;
    private long transferId;


    public TransactionModel() {

    }


    public TransactionModel(long transactionTypeId, double amount, double prevAmount, double currAmount, String description, long transferId) {
        this.transactionTypeId = transactionTypeId;
        this.amount = amount;
        this.prevAmount = prevAmount;
        this.currAmount = currAmount;
        this.description = description;
        this.transferId = transferId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrevAmount() {
        return prevAmount;
    }

    public void setPrevAmount(double prevAmount) {
        this.prevAmount = prevAmount;
    }

    public double getCurrAmount() {
        return currAmount;
    }

    public void setCurrAmount(double currAmount) {
        this.currAmount = currAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }


    @Override
    public String toString() {
        return "TransactionModel{" +
                "transactionId=" + transactionId +
                ", transactionTypeId=" + transactionTypeId +
                ", amount=" + amount +
                ", prevAmount=" + prevAmount +
                ", currAmount=" + currAmount +
                ", description='" + description + '\'' +
                ", transferId=" + transferId +
                '}';
    }

}
