package com.miniproject.minibank.customer;

import com.miniproject.minibank.customer.dto.CustomerReq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(CustomerReq request) {
        Customer customer = Customer.builder()
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .age(request.getAge())
                        .email(request.getEmail())
                        .organization(request.getOrganization())
                        .grade("일반")
                        .build();
        customerRepository.save(customer);
    }


}
