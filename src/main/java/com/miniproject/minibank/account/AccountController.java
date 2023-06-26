package com.miniproject.minibank.account;

import com.miniproject.minibank.account.dto.AccountGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts")  // TODO : header
    public List<AccountGetResponse> getAccounts(@RequestParam long id) {
        return accountService.getAccounts(id);
    }

}
