package com.customerRewards.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private final TransactionRepository transactionRepository;


    public boolean isTransactionHavingThreeMonthsHistory(){
        List<Transactions> transactionsList = (List<Transactions>) transactionRepository.findAll();
        HashSet<Integer> monthData = new HashSet<>();
        HashSet<Integer> yearData = new HashSet<>();
        for (Transactions transactions:transactionsList) {
            monthData.add(transactions.getPurchaseDate().getMonth().getValue());
            yearData.add(transactions.getPurchaseDate().getYear());

            if(monthData.size() > 3 || yearData.size() > 1){
                return false;
            }
        }

        return (Collections.max(monthData) - Collections.min(monthData) < 3);
    }


    public List<Transactions> getAllTransaction(){
        return (List<Transactions>) transactionRepository.findAll();
    }

}
