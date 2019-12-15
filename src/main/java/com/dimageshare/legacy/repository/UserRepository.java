package com.dimageshare.legacy.repository;

import com.dimageshare.legacy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bac-ta
 * */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}