package com.infy.SpringData_Pagination.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    private Integer transactionId;
    private LocalDate transactionDate;
    private Float transactionAmount;

    public Integer getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Integer transactionId) {
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
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return this.transactionId.equals(that.transactionId) && this.transactionDate.equals(that.transactionDate) && this.transactionAmount.equals(that.transactionAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.transactionId, this.transactionDate, this.transactionAmount);
    }
}
