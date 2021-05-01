package com.backtestingbug.stock.entity;


import com.backtestingbug.common.entity.CommonEntity;
import com.backtestingbug.common.enums.CurrencyCd;
import com.backtestingbug.stock.enums.StockExchangeCd;
import lombok.*;

import javax.persistence.*;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 주식 엔티티
 */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "STOCK")
public class Stock extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STOCK_ID", columnDefinition = "BIGINT UNSIGNED", length = 10)
    private Long stockId;

    @Column(name = "STOCK_NM", length = 200, nullable = false)
    private String stockNm;

    @Column(name = "STOCK_SYMBOL", length = 10, nullable = false)
    private String stockSymbol;

    @Column(name = "STOCK_MARKET_CAP_PRICE", precision = 20, scale = 5, nullable = false)
    private String stockMarketCapPrice;

    @Column(name = "STOCK_SHARES_AMT", columnDefinition = " BIGINT UNSIGNED", length = 10, nullable = false)
    private Long stockSharesAmt;

    @Column(name = "CURRENCY_CD", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyCd currencyCd;

    @Column(name = "STOCK_EXCHANGE_CD", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private StockExchangeCd stockExchangeCd;

}
