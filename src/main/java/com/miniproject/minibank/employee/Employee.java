package com.miniproject.minibank.employee;

import com.miniproject.minibank.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * id - 직원 아이디, name - 직원이름 , branchId - 소속지점 아이디
 */
@Entity
public class Employee  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int branchId;
}
