package com.customerRewards.customer;

import com.customerRewards.rewards.Rewards;
import com.customerRewards.rewards.RewardsMonthly;
import com.customerRewards.transactions.TransactionService;
import com.customerRewards.transactions.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customerRewards")
public class CustomerController {
    private final TransactionService transactionService;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService, TransactionService transactionService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }


    @GetMapping(path = "/Rewards")
    public List<Rewards> getTotalCustomerRewards(){

        return customerService.getTotalCustomerRewards();
    }

    @GetMapping(path = "/Rewards/{customerID}")
    public RewardsMonthly getIndividualCustomerRewards(@PathVariable Long customerID){
        return customerService.getIndividualCustomerRewards(customerID);
    }

    @GetMapping(path = "/Transactions")
    public List<Transactions> getTransactions(){
        return transactionService.getAllTransaction();
    }
}
