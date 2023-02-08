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
                    "Rajeev",
                    30,
                    LocalDate.of(1992, Month.JULY,10),
                    "rajeev@gmail.com"
            );

            Customer nancy = new Customer(
                    "Nancy",
                    20,
                    LocalDate.of(2002,Month.JULY,20),
                    "nancy123@gmail.com"
            );

            Transactions bharathFirstTransaction = new Transactions(
                    "bharathbs294@gmail.com",
                    "Bharath",
                    1000L,
                    LocalDate.of(2022,Month.MAY,30)
            );

            Transactions bharathSecondTransaction = new Transactions(
                    "bharathbs294@gmail.com",
                    "Bharath",
                    100L,
                    LocalDate.of(2022,Month.JUNE,30)
            );

            Transactions ricardoFirstTransaction = new Transactions(
                    "rajeev@gmail.com",
                    "Rajeev",
                    960L,
                    LocalDate.of(2022,Month.JUNE,29)
            );

            Transactions ricardoSecondTransaction = new Transactions(
                    "rajeev@gmail.com",
                    "Rajeev",
                    100L,
                    LocalDate.of(2022,Month.JUNE,29)
            );

            Transactions ricardoThirdTransaction = new Transactions(
                    "rajeev@gmail.com",
                    "Rajeev",
                    118L,
                    LocalDate.of(2022,Month.JULY,28)
            );

            Transactions nancyFirstTransaction = new Transactions(
                    "nancy123@gmail.com",
                    "Nancy",
                    10000L,
                    LocalDate.of(2022,Month.JULY,10)
            );

            customerRepository.saveAll(List.of(bharath,ricardo,nancy));
            transactionRepository.saveAll(List.of(bharathFirstTransaction,bharathSecondTransaction,ricardoFirstTransaction,
                    ricardoSecondTransaction,ricardoThirdTransaction,nancyFirstTransaction));

        };
    }
}
