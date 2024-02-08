
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavingRegisterrepository extends JpaRepository<LeavingRegisterrepository,Integer>{}