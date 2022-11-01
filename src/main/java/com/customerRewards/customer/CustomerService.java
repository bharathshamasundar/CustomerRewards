package com.customerRewards.customer;

import com.customerRewards.rewards.RewardsMonthly;
import com.customerRewards.transactions.TransactionRepository;
import com.customerRewards.transactions.Transactions;
import com.customerRewards.rewards.Rewards;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CustomerService {
    public CustomerService(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;



    public List<Rewards> getTotalCustomerRewards(){
        List<Customer> customerList = customerRepository.findAll();
        List<Rewards> rewardsList = new ArrayList<>();

        for (Customer customer: customerList) {
            List<Transactions> transactionsList = transactionRepository.findTransactionsByCustomerEmail(customer.getEmail());
            Long totalRewards = 0L;
            Long purchaseAmount;

            
            Rewards rewards = new Rewards();
            rewards.setName(customer.getName());
            rewards.setEmail(customer.getEmail());
            
            for(Transactions transactions: transactionsList){
                purchaseAmount = transactions.getTotalPurchaseAmount();
                
                if(purchaseAmount <=50L){
                    //do nothing as you accumulate no points
                } else if (purchaseAmount > 50L && purchaseAmount <=100L) {
                    totalRewards+=purchaseAmount - 50L;
                }else{
                    totalRewards+=50;
                    totalRewards+=(purchaseAmount - 100) * 2;
                }
            }

            rewards.setTotalRewardPoints(totalRewards);
            
            rewardsList.add(rewards);
        }

        return rewardsList;

    }

    public RewardsMonthly getIndividualCustomerRewards(Long customerID){
        Customer customer = customerRepository.findCustomerById(customerID);
        List<Transactions> transactionsList = transactionRepository.findTransactionsByCustomerEmail(customer.getEmail());
        Long purchaseAmount,monthlyRewards;
        String month;
        RewardsMonthly rewardsMonthly = new RewardsMonthly();
        rewardsMonthly.setEmail(customer.getEmail());
        rewardsMonthly.setName(customer.getName());
        HashMap<String,Long> rewardMap = new HashMap<>();

        for(Transactions transactions: transactionsList){
            purchaseAmount = transactions.getTotalPurchaseAmount();
            month = transactions.getPurchaseDate().getMonth().toString();
            monthlyRewards = 0L;


            if(purchaseAmount <=50L){
                //do nothing as you accumulate no points
            } else if (purchaseAmount > 50L && purchaseAmount <=100L) {
                monthlyRewards = purchaseAmount - 50L;
            }else{
                monthlyRewards = 50L;
                monthlyRewards+=(purchaseAmount - 100) * 2;
            }

            if(rewardMap.containsKey(month)){
                rewardMap.put(month, rewardMap.get(month) + monthlyRewards);
            }else{
                rewardMap.put(month,monthlyRewards);
            }
        }
        rewardsMonthly.setRewardsMap(rewardMap);
        return rewardsMonthly;
    }

}
