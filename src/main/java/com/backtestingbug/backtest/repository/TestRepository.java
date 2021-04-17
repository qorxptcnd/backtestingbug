package com.backtestingbug.backtest.repository;

import com.backtestingbug.backtest.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description :
 */
@Repository
public interface TestRepository extends JpaRepository<Test, String> {
}
