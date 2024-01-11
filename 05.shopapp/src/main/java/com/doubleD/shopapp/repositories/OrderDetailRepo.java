package com.doubleD.shopapp.repositories;

import com.doubleD.shopapp.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
}
