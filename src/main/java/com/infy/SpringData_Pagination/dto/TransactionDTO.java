package com.infy.SpringData_Pagination.dto;

import java.time.LocalDate;

public class TransactionDTO {
    private Integer transactionId;
    private LocalDate transactionDate;
    private Float transactionAmount;

    public TransactionDTO(Integer transactionId, LocalDate transactionDate, Float transactionAmount){
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public Integer getTransactionId(){
        return this.transactionId;
    }

    public void setTransactionId(Integer transactionId){
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Float getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setTransactionAmount(Float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString(){
        return "Transaction [transactionId= " +transactionId +", "+
                "transactionDate= "  +transactionDate + ", "+
                "transactionAmount= " +transactionAmount+ "]";
    }
}
