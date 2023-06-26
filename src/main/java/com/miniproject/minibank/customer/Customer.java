package com.miniproject.minibank.customer;

import com.miniproject.minibank.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * id - 아이디, name - 사용자이름
 * grade - 등급, age - 나이
 * email - 이메일, organization - 회사
 */
@Entity
public class Customer  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String grade;

    private int age;

    private String email;

    private String organization;


}
