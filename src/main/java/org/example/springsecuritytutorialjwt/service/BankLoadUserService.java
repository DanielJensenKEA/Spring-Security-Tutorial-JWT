package org.example.springsecuritytutorialjwt.service;

import org.example.springsecuritytutorialjwt.CustomerRepository.CustomerRepository;
import org.example.springsecuritytutorialjwt.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankLoadUserService implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = null;
        String cusUsername = null;
        String password = null;
        Optional<Customer> customer = customerRepository.findCustomerByEmail(username);
        if (customer.isPresent()) {
            cusUsername = customer.get().getEmail();
            password = customer.get().getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get().getRole()));
        } else {
            throw new UsernameNotFoundException("User details not found for user: "+username);
        }
        return new User(cusUsername, password, authorities);
    }
}
