package com.miniproject.minibank.account;

import com.miniproject.minibank.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 *  number - 계좌번호, type - 계좌타입
 *  balance - 잔액, password - 패스워드
 *  employeeId - 담당직원 아이디, branch_id - 담당지점 아이디
 *  customerId - 고객 아이디
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Account extends BaseEntity {

    @Id
    private String number;

    private String type;

    private long balance;

    private String password;

    private int employeeId;

    private int branchId;

    private long customerId;




}
