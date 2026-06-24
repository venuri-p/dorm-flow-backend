package com.dormflow.dorm_flow_backend.repository;


import com.dormflow.dorm_flow_backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    // Basic CRUD and finder operations for rooms are derived out-of-the-box
}