package com.miniproject.minibank.customer;

import com.miniproject.minibank.customer.dto.CustomerReq;
import com.miniproject.minibank.customer.dto.CustomerRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerRes> signUp(@RequestBody CustomerReq request) {
        customerService.signUp(request);
        return ResponseEntity.ok(
                CustomerRes.builder().
                         name(request.getName())
                        .age(request.getAge())
                        .email(request.getEmail())
                        .organization(request.getOrganization())
                        .build()
        );
    }
}
