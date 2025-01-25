package com.dk.myownecommerce.repositories;

import com.dk.myownecommerce.core.repository.BaseRepository;
import com.dk.myownecommerce.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product> {
}
