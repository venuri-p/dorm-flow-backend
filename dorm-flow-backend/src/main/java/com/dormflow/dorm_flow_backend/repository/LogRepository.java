package com.dormflow.dorm_flow_backend.repository;

import com.dormflow.dorm_flow_backend.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    
    // Fetches live log history sorted sequentially by the newest transaction first
    List<Log> findByOrderByTimestampDesc();
}

