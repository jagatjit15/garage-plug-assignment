package com.garageplug.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garageplug.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
	


}
