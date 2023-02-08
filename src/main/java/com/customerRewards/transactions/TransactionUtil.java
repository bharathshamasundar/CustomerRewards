package com.customerRewards.transactions;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class TransactionUtil {

    public static Transactions setTransactionValues(){
        Transactions transactionDetails = new Transactions();

        transactionDetails.setCustomerEmail("bharathxyz@gmail.com");
        transactionDetails.setCustomerName("Bharath");
        transactionDetails.setPurchaseDate(LocalDate.of(2020, Month.MAY,20));

        return transactionDetails;
    }

    public static List<Transactions> getMultipleTransactionValues(){
        Transactions transactionsDetailsFirst = new Transactions();

        transactionsDetailsFirst.setCustomerEmail("bharathxyz@gmail.com");
        transactionsDetailsFirst.setCustomerName("Bharath");
        transactionsDetailsFirst.setPurchaseDate(LocalDate.of(2020, Month.MAY,20));


        Transactions transactionsDetailsSecond = new Transactions();

        transactionsDetailsSecond.setCustomerEmail("karthikxyz@gmail.com");
        transactionsDetailsSecond.setCustomerName("Karthik");
        transactionsDetailsSecond.setPurchaseDate(LocalDate.of(2020, Month.JUNE,20));


        Transactions transactionsDetailsThird = new Transactions();

        transactionsDetailsThird.setCustomerEmail("ricardoxyz@gmail.com");
        transactionsDetailsThird.setCustomerName("Ricardo");
        transactionsDetailsThird.setPurchaseDate(LocalDate.of(2020, Month.JULY,20));

        return List.of(transactionsDetailsFirst,transactionsDetailsSecond,transactionsDetailsThird);

    }
}
