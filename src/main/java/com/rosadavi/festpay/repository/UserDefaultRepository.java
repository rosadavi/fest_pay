package com.rosadavi.festpay.repository;

import com.rosadavi.festpay.entity.UserDefault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDefaultRepository extends JpaRepository<UserDefault, UUID> {
    Optional<UserDefault> findByEmail(String email);
}
