package com.miniproject.minibank.transaction;

import com.miniproject.minibank.transaction.dto.TransferPostRequest;
import com.miniproject.minibank.transaction.dto.TransferPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TransactionController {

    private final TransactionService transactionService;
    @PostMapping("/transfer")
    public ResponseEntity<TransferPostResponse> transfer(@RequestBody TransferPostRequest request) {
        transactionService.transfer(request);
        return ResponseEntity.ok(TransferPostResponse.builder().resultMessage("정상적으로 처리되었습니다.").resultCode("00").build());
    }
}
