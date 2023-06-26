package com.miniproject.minibank.account;

import com.miniproject.minibank.account.dto.AccountGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<AccountGetResponse> getAccounts(long customerId) {
        return accountRepository.findAccountByCustomerId(customerId)
                .stream().map(account -> AccountGetResponse.builder()
                        .number(account.getNumber())
                        .balance(account.getBalance())
                        .branchId(account.getBranchId())
                        .customerId(account.getCustomerId())
                        .build())
                .collect(Collectors.toList());
    }
}
