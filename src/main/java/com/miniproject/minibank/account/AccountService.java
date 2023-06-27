package com.miniproject.minibank.account;

import com.miniproject.minibank.account.dto.AccountGetResponse;
import com.miniproject.minibank.account.dto.DetailAccount;
import com.miniproject.minibank.transaction.Transaction;
import com.miniproject.minibank.transaction.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

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

    public DetailAccount getAccountDetail(String accountNumber, LocalDateTime viewYearMonth) {
        Account account = accountRepository.findAccountByNumber(accountNumber).orElseThrow();
        LocalDateTime startDate = viewYearMonth.plusDays(1);
        LocalDateTime endDate = viewYearMonth.plusMonths(1).minusDays(1);
        List<Transaction> transactionList = transactionRepository.findByAccountNumberAndCreatedAtBetween(accountNumber, startDate, endDate);

        return DetailAccount.builder()
                .accountNumber(account.getNumber())
                .accountAmount(account.getBalance())
                .accountType(account.getType())
                .depositAndWithdrawalHistory(transactionList)
                .build();
    }
}
