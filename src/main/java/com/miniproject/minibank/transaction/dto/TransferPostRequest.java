package com.miniproject.minibank.transaction.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TransferPostRequest {
    private String requestAccountNumber;
    //private String requestType;
    private long amount;
    //private String accountToken;
    private String targetAccountNumber;

}
