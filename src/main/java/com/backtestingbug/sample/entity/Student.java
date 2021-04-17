package com.backtestingbug.sample.entity;

import com.backtestingbug.sample.enums.MajorCd;
import lombok.Data;

import javax.persistence.*;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description : 학생 엔티티
 */

@Data
@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(length = 100)
    private String name;

    @Column(nullable = false)
    private Long age;

    @Column
    @Enumerated(EnumType.STRING)
    private MajorCd majorCd;
}
