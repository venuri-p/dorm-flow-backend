package com.dormflow.dorm_flow_backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_number", length = 50)
    private String roomNumber;

    @Column(name = "block_name", length = 100, nullable = false)
    private String blockName;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "current_occupancy")
    private int currentOccupancy = 0;

    // One room can have many active or historically assigned students
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<Student> students;

    // Constructors
    public Room() {}

    public Room(String roomNumber, String blockName, int capacity) {
        this.roomNumber = roomNumber;
        this.blockName = blockName;
        this.capacity = capacity;
    }

    // Getters and Setters
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getBlockName() { return blockName; }
    public void setBlockName(String blockName) { this.blockName = blockName; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getCurrentOccupancy() { return currentOccupancy; }
    public void setCurrentOccupancy(int currentOccupancy) { this.currentOccupancy = currentOccupancy; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}