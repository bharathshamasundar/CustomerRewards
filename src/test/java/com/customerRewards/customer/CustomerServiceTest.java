package com.customerRewards.customer;

import com.customerRewards.transactions.TransactionRepository;
import com.customerRewards.transactions.TransactionUtil;
import com.customerRewards.transactions.Transactions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository,transactionRepository);
    }

    @AfterEach
    void cleanUp() {
        customerRepository.deleteAll();
        transactionRepository.deleteAll();
    }

    @Test
    void verifyTotalCustomerRewards() {
        underTest.getTotalCustomerRewards();
    }

    @Test
    void verifyRewardsForHundredDollarsPurchase() {
       Customer customerExample = CustomerUtil.setCustomerValues();
       Transactions transactionExample = TransactionUtil.setTransactionValues();

       transactionExample.setTotalPurchaseAmount(100L);

        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);
        assertEquals(CustomerUtil.totalRewards(underTest.getIndividualCustomerRewards(customerExample.getId()).getRewardsMap()),50L);
    }

    @Test
    void verifyRewardsForFiftyDollarsPurchase() {
        Customer customerExample = CustomerUtil.setCustomerValues();
        Transactions transactionExample = TransactionUtil.setTransactionValues();

        transactionExample.setTotalPurchaseAmount(50L);

        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);
        assertEquals(CustomerUtil.totalRewards(underTest.getIndividualCustomerRewards(customerExample.getId()).getRewardsMap()),0L);
    }

    @Test
    void verifyRewardsForLessThanFiftyDollarsPurchase() {
        Customer customerExample = CustomerUtil.setCustomerValues();
        Transactions transactionExample = TransactionUtil.setTransactionValues();

        transactionExample.setTotalPurchaseAmount(30L);

        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);
        assertEquals(CustomerUtil.totalRewards(underTest.getIndividualCustomerRewards(customerExample.getId()).getRewardsMap()),0L);
    }

    @Test
    void verifyRewardsForGreaterThanHundredDollarsPurchase() {
        Customer customerExample = CustomerUtil.setCustomerValues();
        Transactions transactionExample = TransactionUtil.setTransactionValues();

        transactionExample.setTotalPurchaseAmount(130L);

        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);

        assertEquals(CustomerUtil.totalRewards(underTest.getIndividualCustomerRewards(customerExample.getId()).getRewardsMap()),110L);
    }
}