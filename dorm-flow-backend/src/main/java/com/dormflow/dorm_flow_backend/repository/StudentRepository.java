package com.dormflow.dorm_flow_backend.repository;

import com.dormflow.dorm_flow_backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    // 1. Find active students whose allocations have expired (used by the nightly Cron Job)
    @Query("SELECT s FROM Student s WHERE s.accountStatus = 'ACTIVE' AND s.allocationEndDate <= :currentDate")
    List<Student> findExpiredAllocations(@Param("currentDate") LocalDate currentDate);

    // 2. Find all students currently outside the hostel (used for the Warden Dashboard)
    @Query("SELECT s FROM Student s WHERE s.accountStatus = 'ACTIVE' AND s.currentStatus = 'OUT'")
    List<Student> findMissingStudents();
}