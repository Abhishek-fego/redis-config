package com.example.redisconfig.repository;

import com.example.redisconfig.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
