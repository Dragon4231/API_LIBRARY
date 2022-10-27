package com.example.library.repository;

import com.example.library.data.PrintedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintedProductRepository extends JpaRepository<PrintedProduct, Long> {
}
