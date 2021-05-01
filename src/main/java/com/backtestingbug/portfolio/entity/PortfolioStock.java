package com.backtestingbug.portfolio.entity;

import com.backtestingbug.common.entity.CommonEntity;
import com.backtestingbug.portfolio.entity.pk.PortfolioStockPk;
import com.backtestingbug.portfolio.enums.RblncPeriodCd;
import com.backtestingbug.stock.entity.Stock;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 포트폴리오 구성 주식 엔티티
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PORTFOLIO_STOCK")
@IdClass(PortfolioStockPk.class)
public class PortfolioStock extends CommonEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "PRTFL_ID")
    private Portfolio portfolio;

    @Id
    @ManyToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;

    @Column(name = "INVEST_RATIO", precision = 3, scale = 1, nullable = false)
    private BigDecimal investRatio;

    @Column(name = "RBLNC_PERIOD_CD", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private RblncPeriodCd rblncPeriodCd;

}
