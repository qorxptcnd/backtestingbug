package com.backtestingbug.stock.entity;

import com.backtestingbug.common.entity.CommonEntity;
import com.backtestingbug.stock.entity.pk.StockDividendPk;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 주식 내역 엔티티
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "STOCK_HISTORY")
@IdClass(StockDividendPk.class)
public class StockHistory extends CommonEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;

    @Id
    @Column(name = "BASE_DT", nullable = false)
    private LocalDate baseDt;

    @Column(name = "OPEN_PRICE", precision = 20, scale = 5, nullable = false)
    private BigDecimal openPrice;

    @Column(name = "LOW_PRICE", precision = 20, scale = 5, nullable = false)
    private BigDecimal lowPrice;

    @Column(name = "HIGH_PRICE", precision = 20, scale = 5, nullable = false)
    private BigDecimal highPrice;

    @Column(name = "CLOSE_PRICE", precision = 20, scale = 5, nullable = false)
    private BigDecimal closePrice;

    @Column(name = "ADJUST_CLOSE_PRICE", precision = 20, scale = 5, nullable = false)
    private BigDecimal adjustClosePrice;

    @Column(name = "VOLUME_AMT", columnDefinition = " BIGINT UNSIGNED", length = 10, nullable = false)
    private Long volumeAmt;

}
