package com.customerRewards.customer;

import com.customerRewards.transactions.TransactionRepository;
import com.customerRewards.transactions.Transactions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository, TransactionRepository transactionRepository){
        return args -> {
            Customer bharath = new Customer(
                    "Bharath",
                    29,
                    LocalDate.of(1993, Month.MAY,10),
                    "bharathbs294@gmail.com"
            );

            Customer ricardo = new Customer(
                    "Ricardo",
                    30,
                    LocalDate.of(1993, Month.JULY,10),
                    "ricardomorales@gmail.com"
            );

            Transactions bharathTransaction = new Transactions(
                    "bharathbs294@gmail.com",
                    "bharath",
                    1000L,
                    LocalDate.of(2022,Month.MAY,30)
            );

            Transactions ricardoTransaction = new Transactions(
                    "ricardomorales@gmail.com",
                    "bharath",
                    1000L,
                    LocalDate.of(2022,Month.JUNE,30)
            );

            customerRepository.saveAll(List.of(bharath,ricardo));
            transactionRepository.saveAll(List.of(bharathTransaction,ricardoTransaction));

        };
    }
}
