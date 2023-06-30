package com.miniproject.minibank.customer.dto;

import lombok.Getter;

@Getter
public class CustomerReq {
    private String password;

    private String name;
    private int age;
    private String email;
    private String organization;
}
