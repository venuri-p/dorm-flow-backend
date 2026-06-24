package com.dormflow.dorm_flow_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id", length = 50)
    private String studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_number", referencedColumnName = "room_number")
    private Room room; // Will be set to NULL automatically when the student goes INACTIVE

    @Column(name = "account_status", length = 20)
    private String accountStatus = "ACTIVE"; // ACTIVE, INACTIVE

    @Column(name = "current_status", length = 20)
    private String currentStatus = "IN"; // IN, OUT, LATE_MISSING

    @Column(name = "allocated_at", nullable = false)
    private LocalDate allocatedAt;

    @Column(name = "allocation_end_date", nullable = false)
    private LocalDate allocationEndDate; // Flexible cutoff day calculated upon move-in

    @Column(name = "inactivated_at")
    private LocalDateTime inactivatedAt; // Tracks exact moment for 5-year data compliance

    // Constructors
    public Student() {}

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    public String getAccountStatus() { return accountStatus; }
    public void setAccountStatus(String accountStatus) { this.accountStatus = accountStatus; }

    public String getCurrentStatus() { return currentStatus; }
    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }

    public LocalDate getAllocatedAt() { return allocatedAt; }
    public void setAllocatedAt(LocalDate allocatedAt) { this.allocatedAt = allocatedAt; }

    public LocalDate getAllocationEndDate() { return allocationEndDate; }
    public void setAllocationEndDate(LocalDate allocationEndDate) { this.allocationEndDate = allocationEndDate; }

    public LocalDateTime getInactivatedAt() { return inactivatedAt; }
    public void setInactivatedAt(LocalDateTime inactivatedAt) { this.inactivatedAt = inactivatedAt; }
}
