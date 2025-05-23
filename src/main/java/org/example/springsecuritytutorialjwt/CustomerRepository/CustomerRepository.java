package org.example.springsecuritytutorialjwt.CustomerRepository;

import org.example.springsecuritytutorialjwt.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByEmail(String email);
}
