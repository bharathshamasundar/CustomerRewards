package com.customerRewards.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private final TransactionRepository transactionRepository;


    public List<Transactions> getAllTransaction(){
        return transactionRepository.findAll();
    }

}
