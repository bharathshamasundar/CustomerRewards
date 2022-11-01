package com.customerRewards.transactions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TransactionServiceTest {

    @Autowired
    private TransactionRepository transactionRepository;

    private TransactionService underTest;

    @BeforeEach
    void setUp() {
        underTest = new TransactionService(transactionRepository);
    }

    @AfterEach
    void tearDown() {
        transactionRepository.deleteAll();
    }

    @Test
    void checkIfTransactionsAreWithinThreeMonths() {
        transactionRepository.saveAll(TransactionUtil.getMultipleTransactionValues());
        assertTrue(underTest.isTransactionHavingThreeMonthsHistory());
    }

    @Test
    void checkIfTransactionsPresent() {
        transactionRepository.saveAll(TransactionUtil.getMultipleTransactionValues());
        assertTrue(underTest.getAllTransaction().size() > 0);
    }
}