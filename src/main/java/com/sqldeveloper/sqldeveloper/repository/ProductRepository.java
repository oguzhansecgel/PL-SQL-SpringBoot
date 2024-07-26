package com.sqldeveloper.sqldeveloper.repository;

import com.sqldeveloper.sqldeveloper.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
