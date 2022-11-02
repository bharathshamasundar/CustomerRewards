package com.customerRewards.customer;

import com.customerRewards.rewards.RewardsUtil;
import com.customerRewards.transactions.TransactionService;
import com.customerRewards.transactions.TransactionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    void getTotalCustomerRewards() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        when(customerService.getTotalCustomerRewards()).thenReturn(RewardsUtil.getTotalRewardsForTesting());
        mockMvc.perform(get("/api/v1/customerRewards/Rewards"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo(objectMapper.writeValueAsString(RewardsUtil.getTotalRewardsForTesting()))));
        verify(customerService).getTotalCustomerRewards();
    }

    @Test
    void getIndividualCustomerRewards() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        when(customerService.getIndividualCustomerRewards(1L)).thenReturn(RewardsUtil.getMonthlyRewardsForTesting());
        mockMvc.perform(get("/api/v1/customerRewards/Rewards/{customerID}",1L))
                .andExpect(status().isOk()).andExpect(content().string(equalTo(objectMapper.writeValueAsString(RewardsUtil.getMonthlyRewardsForTesting()))));
        verify(customerService).getIndividualCustomerRewards(1L);

    }

    @Test
    void checkIfTransactionsExist() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        when(transactionService.getAllTransaction()).thenReturn(TransactionUtil.getMultipleTransactionValues());
        mockMvc.perform(get("/api/v1/customerRewards/Transactions"))
        .andExpect(status().isOk()).andExpect(content().string(equalTo(objectMapper.writeValueAsString(TransactionUtil.getMultipleTransactionValues()))));
        verify(transactionService).getAllTransaction();
    }
}