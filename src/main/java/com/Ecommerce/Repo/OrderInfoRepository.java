package com.Ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.Ecommerce.entity.OrderJpaRecord;

public interface OrderInfoRepository extends JpaRepository<OrderInfoRepository, Integer>, JpaSpecificationExecutor<OrderJpaRecord> {

}
