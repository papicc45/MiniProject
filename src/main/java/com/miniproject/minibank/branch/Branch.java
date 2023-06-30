package com.miniproject.minibank.branch;

import com.miniproject.minibank.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *  id - 지점 아이디, name - 지점명 , address - 주소
 */
@Entity
public class Branch  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address;
}
