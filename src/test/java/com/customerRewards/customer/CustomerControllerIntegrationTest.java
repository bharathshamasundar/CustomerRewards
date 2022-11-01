package com.customerRewards.customer;

import com.customerRewards.transactions.TransactionRepository;
import com.customerRewards.transactions.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private TransactionService transactionService;

    @Test
    void getTotalCustomerRewards() {
    }

    @Test
    void getIndividualCustomerRewards() {
    }

    @Test
    void checkIfTransactionsExist() {
        when(transactionService.getAllTransaction()).thenReturn();

    }
}