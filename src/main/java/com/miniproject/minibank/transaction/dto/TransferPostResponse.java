package com.miniproject.minibank.transaction.dto;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransferPostResponse {
    private String resultCode;
    private String resultMessage;
}
