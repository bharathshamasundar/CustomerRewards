package com.customerRewards.transactions;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Transactions {

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long transactionId;

    private String customerEmail;
    private String customerName;
    private Long totalPurchaseAmount;

    private LocalDate purchaseDate;


    public Transactions() {
    }

    public Transactions(Long transactionId, String customerEmail, String customerName, Long totalPurchaseAmount, LocalDate purchaseDate) {
        this.transactionId = transactionId;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.purchaseDate = purchaseDate;
    }

    public Transactions(String customerEmail, String customerName, Long totalPurchaseAmount, LocalDate purchaseDate) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.purchaseDate = purchaseDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(Long totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
