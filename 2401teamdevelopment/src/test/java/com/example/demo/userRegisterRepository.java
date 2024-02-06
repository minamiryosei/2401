package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ユーザー情報 Repository
 */
@userRegisterRepository
public interface userRegisterRepository extends JpaRepository<User, Long> {}