package com.dk.myownecommerce.repositories;

import com.dk.myownecommerce.core.repository.BaseRepository;
import com.dk.myownecommerce.models.WebUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<WebUser> {
    Optional<WebUser> findByUsername(String username);
    Optional<WebUser> findByEmail(String email);
}
