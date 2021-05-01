package com.backtestingbug.portfolio.entity.pk;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 포트폴리오 구성 주식 기본키
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PortfolioStockPk implements Serializable {

    private Long portfolio;

    private LocalDate stock;

}
