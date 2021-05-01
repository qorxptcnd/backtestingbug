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
 * @description : 주식 배당금 엔티티
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "STOCK_DIVIDEND")
@IdClass(StockDividendPk.class)
public class StockDividend extends CommonEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;

    @Id
    @Column(name = "BASE_DT", nullable = false)
    private LocalDate baseDt;

    @Column(name = "ADJUST_DIVIDEND_PRICE", precision = 20, scale = 5, nullable = false)
    private BigDecimal adjustDividendPrice;

}
