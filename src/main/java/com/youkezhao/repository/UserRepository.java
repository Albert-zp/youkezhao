package com.youkezhao.repository;

import com.youkezhao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 根据用户名查找用户
    Optional<User> findByUsername(String username);

    // 根据手机号码查找用户
    Optional<User> findByPhoneNumber(String phoneNumber);

    // 检查用户名是否已存在
    boolean existsByUsername(String username);

    // 检查手机号码是否已存在
    boolean existsByPhoneNumber(String phoneNumber);
}
