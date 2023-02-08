package com.customerRewards.customer;

import com.customerRewards.transactions.TransactionRepository;
import com.customerRewards.transactions.TransactionUtil;
import com.customerRewards.transactions.Transactions;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private CustomerService underTest;

    private Transactions transactionExample;
    private Customer customerExample;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository,transactionRepository);
        customerExample = CustomerUtil.setCustomerValues();
        transactionExample = TransactionUtil.setTransactionValues();
    }

    @AfterEach
    void cleanUp(){
        customerRepository.deleteAll();
        transactionRepository.deleteAll();
    }


    @Test
    void verifyTotalCustomerRewardsPositiveCase() {

        transactionExample.setTotalPurchaseAmount(200L);
        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);

        assertTrue(underTest.getTotalCustomerRewards().size() > 0);
        assertEquals(underTest.getTotalCustomerRewards().get(0).getTotalRewardPoints(),250L);
    }

    @Test
    void verifyNoCustomersPresentForTotalRewards() {
        assertThrows(IllegalArgumentException.class,()-> underTest.getTotalCustomerRewards());
    }

    @Test
    void verifyRewardsForHundredDollarsTotalPurchase() {
        transactionExample.setTotalPurchaseAmount(100L);

        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);

        assertEquals(CustomerUtil.totalRewards(underTest.getIndividualCustomerRewards(customerExample.getId()).getRewardsMap()),50L);
    }

    @Test
    void verifyRewardsForFiftyDollarsTotalPurchase() {
        transactionExample.setTotalPurchaseAmount(50L);

        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);
        assertEquals(CustomerUtil.totalRewards(underTest.getIndividualCustomerRewards(customerExample.getId()).getRewardsMap()),0L);
    }

    @Test
    void verifyRewardsForLessThanFiftyDollarsTotalPurchase() {
        transactionExample.setTotalPurchaseAmount(30L);

        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);
        assertEquals(CustomerUtil.totalRewards(underTest.getIndividualCustomerRewards(customerExample.getId()).getRewardsMap()),0L);
    }

    @Test
    void verifyRewardsForGreaterThanHundredDollarsTotalPurchase() {
        transactionExample.setTotalPurchaseAmount(130L);

        customerRepository.save(customerExample);
        transactionRepository.save(transactionExample);

        assertEquals(CustomerUtil.totalRewards(underTest.getIndividualCustomerRewards(customerExample.getId()).getRewardsMap()),110L);
    }

    @Test
    void verifyNoCustomerForMonthlyRewards() {
        assertThrows(IllegalArgumentException.class,()-> underTest.getIndividualCustomerRewards(customerExample.getId()));

    }

    @Test
    void verifyNoTransactionForMonthlyRewards() {
        customerRepository.save(customerExample);
        assertThrows(RuntimeException.class,()-> underTest.getIndividualCustomerRewards(customerExample.getId()));
    }


}