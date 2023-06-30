package com.miniproject.minibank.customer.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class CustomerRes {

    private String name;

    private int age;

    private String email;

    private String organization;
}
