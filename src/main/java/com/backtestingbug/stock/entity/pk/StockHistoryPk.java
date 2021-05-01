package com.backtestingbug.stock.entity.pk;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 주식 내역 기본키
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class StockHistoryPk implements Serializable {

    private Long stock;

    private LocalDate baseDt;

}
