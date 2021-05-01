package com.backtestingbug.sample.entity;

import com.backtestingbug.sample.enums.MajorCd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description : 학생 엔티티
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "AGE", nullable = false)
    private Long age;

    @Column(name = "MAJOR_CD")
    @Enumerated(EnumType.STRING)
    private MajorCd majorCd;

}
