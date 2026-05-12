package com.rosadavi.festpay.repository;

import com.rosadavi.festpay.entity.UserUpdated;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserUpdatedRepository extends JpaRepository<UserUpdated, UUID> {
}
