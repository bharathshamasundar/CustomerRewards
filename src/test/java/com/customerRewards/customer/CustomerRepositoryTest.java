package com.customerRewards.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository underTest;

    @AfterEach
    void cleanUp() {
        underTest.deleteAll();
    }

    @Test
    void emailShouldExist() {
        String email = "karthikbs@gmail.com";
        List<Customer> customerList = new ArrayList<>();

        Customer customerKarthik = new Customer(
                "karthik",
                29,
                LocalDate.of(1984, Month.SEPTEMBER,25),
                email
        );
        customerList.add(customerKarthik);


        Customer customerBharath = new Customer(
                "bharath",
                29,
                LocalDate.of(1984, Month.SEPTEMBER,25),
                email
        );

        customerList.add(customerBharath);
        underTest.saveAll(customerList);

        List<String> testCustomerByEmail = underTest.selectExistsCustomer();
        assertTrue(testCustomerByEmail.size() > 0);
        for(String testEmail: testCustomerByEmail){
            assertFalse(testEmail.isBlank());
        }
    }
}