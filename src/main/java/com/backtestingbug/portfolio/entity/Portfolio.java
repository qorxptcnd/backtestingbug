package com.backtestingbug.portfolio.entity;

import com.backtestingbug.common.entity.CommonEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 포트폴리오 엔티티
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PORTFOLIO")
public class Portfolio extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRTFL_ID", columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long prtflId;

    @Column(name = "PRTFL_NM", length = 200, nullable = false)
    private String prtflNm;

    @Column(name = "PRTFL_SYMBOL", length = 10, nullable = false)
    private String prtflSymbol;

    @Column(name = "PRTFL_DESC", length = 4000, nullable = false)
    private String prtflDesc;

    @Column(name = "PRTFL_CAGR", precision = 10, scale = 5, nullable = false)
    private BigDecimal prtflCagr;

    @Column(name = "PRTFL_RBLNC_DESC", length = 1000, nullable = false)
    private String prtflRblncDesc;

}
