package com.customerRewards.customer;

import com.customerRewards.rewards.Rewards;
import com.customerRewards.rewards.RewardsMonthly;
import com.customerRewards.transactions.TransactionService;
import com.customerRewards.transactions.Transactions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customerRewards")
@CrossOrigin
public class CustomerController {
    private final TransactionService transactionService;
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService, TransactionService transactionService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }


    @GetMapping(path = "/Rewards")
    public List<Rewards> getTotalCustomerRewards(){

        return customerService.getTotalCustomerRewards();
    }

    @GetMapping(path = "/Rewards/{customerID}")
    public ResponseEntity<RewardsMonthly> getIndividualCustomerRewards(@PathVariable Long customerID){
        return new ResponseEntity<>(customerService.getIndividualCustomerRewards(customerID),HttpStatus.OK);
    }

    @GetMapping(path = "/Transactions")
    public List<Transactions> getTransactions(){
        return transactionService.getAllTransaction();
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgException(IllegalArgumentException exception) {
        JSONObject response = new JSONObject();
        //Could have an Error Response Class in the future that could handle these messages
        response.put("ErrorMessage","Customer Repository is empty" );
        return new ResponseEntity<>(response.toString(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRunTimeException(RuntimeException exception) {
        JSONObject response = new JSONObject();
        response.put("ErrorMessage",exception.getMessage());
        return new ResponseEntity<>(response.toString(), HttpStatus.NOT_FOUND);
    }
}
