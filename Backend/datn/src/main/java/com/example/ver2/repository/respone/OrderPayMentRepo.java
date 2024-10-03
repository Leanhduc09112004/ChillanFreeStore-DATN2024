package com.example.ver2.repository.respone;

import com.example.ver2.entity.OrderPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPayMentRepo extends JpaRepository<OrderPaymentMethod,Integer> {
}
