package com.example.library.repository;

import com.example.library.data.PrintedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


public interface PrintedProductRepository extends JpaRepository<PrintedProduct, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE PrintedProduct p SET p.theme = :newTheme WHERE p.ID = :id")
    void updateTheme(@Param("id") Long id,@Param("newTheme") String newTheme);

    @Transactional
    @Modifying
    @Query("UPDATE PrintedProduct p SET p.author = :author WHERE p.ID = :id")
    void updateAuthor(@Param("id") Long id,@Param("author") String author);

    @Transactional
    @Modifying
    @Query("UPDATE PrintedProduct p SET p.publication = :publication WHERE p.ID = :id")
    void updatePublication(@Param("id") Long id,@Param("publication") String publication);

    @Transactional
    @Modifying
    @Query("UPDATE PrintedProduct p SET p.typeOfProduct = :typeOfProduct WHERE p.ID = :id")
    void updateTypeOfProduct(@Param("id") Long id,@Param("typeOfProduct") PrintedProduct.Type typeOfProduct);

    @Transactional
    @Modifying
    @Query("UPDATE PrintedProduct p SET p.date = :date WHERE p.ID = :id")
    void updateDate(@Param("id") Long id,@Param("date") Date date);

}
