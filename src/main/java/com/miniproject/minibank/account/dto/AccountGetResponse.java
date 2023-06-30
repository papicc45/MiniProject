package com.miniproject.minibank.account.dto;

import com.miniproject.minibank.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@ToString
public class AccountGetResponse {


    private String number;

    private String type;

    private long balance;

    private String password;

    private int employeeId;

    private int branchId;

    private long customerId;




}
