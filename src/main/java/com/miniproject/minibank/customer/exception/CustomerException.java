package com.miniproject.minibank.customer.exception;

import com.miniproject.minibank.exception.BaseException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomerException extends BaseException {
    private final long id;
    private final String name;
}
