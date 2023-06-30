package com.miniproject.minibank.account;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findAccountByCustomerId(long customerId);

    Optional<Account> findAccountByNumber(String accountNumber);
}
