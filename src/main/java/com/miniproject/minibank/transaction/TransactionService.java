package com.miniproject.minibank.transaction;

import com.miniproject.minibank.account.Account;
import com.miniproject.minibank.account.AccountRepository;
import com.miniproject.minibank.transaction.dto.TransferPostRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public void transfer(TransferPostRequest request) {
        Account withdrawAccount = accountRepository.findAccountByNumber(request.getRequestAccountNumber()).orElseThrow();
        transactionRepository.save(withdrawOrDeposit(request, 1, withdrawAccount.getBalance()));


        Account depositAccount = accountRepository.findAccountByNumber(request.getTargetAccountNumber()).orElseThrow();
        transactionRepository.save(withdrawOrDeposit(request, 0, depositAccount.getBalance()));

    }

    private Transaction withdrawOrDeposit(TransferPostRequest request, int code, long amount) {
        Transaction transaction;
        if(code == 1) {
            transaction = Transaction.builder()
                    .balance(request.getAmount())
                    .type("출금")
                    .balanceAfterTransaction(amount - request.getAmount())
                    .accountNumber(request.getRequestAccountNumber())
                    .build();
        } else {
            transaction = Transaction.builder()
                    .balance(request.getAmount())
                    .type("입금")
                    .balanceAfterTransaction(amount + request.getAmount())
                    .accountNumber(request.getTargetAccountNumber())
                    .build();
        }

        return transaction;
    }
}
