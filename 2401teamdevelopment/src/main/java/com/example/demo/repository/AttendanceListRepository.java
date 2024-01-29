
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AttendanceListEntity;

/**
 * 勤怠一覧 Repository
 */
@Repository
public interface AttendanceListRepository extends JpaRepository<AttendanceListEntity, Long> {}