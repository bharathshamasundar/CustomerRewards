package com.customerRewards.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findCustomerById(Long id);
    Customer findCustomerByEmail(String email);

    @Query(value = "SELECT c.email FROM Customer c",
            nativeQuery = true
    )
    List<String> selectExistsCustomer();


}
