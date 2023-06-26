package com.miniproject.minibank.customer.exception;

import com.miniproject.minibank.exception.BaseException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class CustomerNotFoundException extends CustomerException {
    public CustomerNotFoundException(long id, String name) {
        super(id, name);
    }

}
