package com.dk.myownecommerce.repositories;

import com.dk.myownecommerce.core.repository.BaseRepository;
import com.dk.myownecommerce.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends BaseRepository<Product> {

    @Query("SELECT p FROM Product p")
    Set<Product> findAllProducts();
}
