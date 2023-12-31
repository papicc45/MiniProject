package com.miniproject.minibank.account;

import com.miniproject.minibank.account.dto.AccountGetResponse;
import com.miniproject.minibank.account.dto.DetailAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping()  // TODO : header
    public ResponseEntity<List<AccountGetResponse>> getAccounts(@RequestParam long customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccounts(customerId));
    }

    @GetMapping("/{accountNumber}/detail")
    public ResponseEntity<DetailAccount> getAccountDetail(@RequestParam long customerId,
                                                                                            @PathVariable String accountNumber,
                                                                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime viewYearMonth) {
        // TODO : customerId 검증
        return ResponseEntity.ok(accountService.getAccountDetail(accountNumber, viewYearMonth));
    }

}
