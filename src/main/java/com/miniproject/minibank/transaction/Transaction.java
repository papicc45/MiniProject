package com.miniproject.minibank.transaction;

import com.miniproject.minibank.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * id - 인덱스, balance - 금액
 * type - 거래종류 , balanceAfterTransaction - 거래후 금액
 * accountNumber - 계좌번호
 */
@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Transaction  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long balance;

    private String type;

    private long balanceAfterTransaction;

    private String accountNumber;
}
