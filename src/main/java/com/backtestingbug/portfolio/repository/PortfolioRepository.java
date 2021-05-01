package com.backtestingbug.portfolio.repository;

import com.backtestingbug.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 포트폴리오 레퍼지토리
 */
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
