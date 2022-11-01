package com.customerRewards.customer;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

public class CustomerUtil {

    public static Customer setCustomerValues(){
        Customer customerDetails = new Customer();

        customerDetails.setName("Bharath");
        customerDetails.setAge(20);
        customerDetails.setDob(LocalDate.of(2002, Month.JUNE,20));
        customerDetails.setEmail("bharathxyz@gmail.com");

        return customerDetails;
    }

    public static Long totalRewards(HashMap<String,Long> rewardsMap){
        Long totalPoints = 0L;
        for (Long points:rewardsMap.values()) {
            totalPoints+=points;
        }
        return totalPoints;
    }

}
