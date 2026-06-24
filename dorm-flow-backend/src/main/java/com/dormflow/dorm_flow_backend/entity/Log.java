package com.dormflow.dorm_flow_backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.time.LocalDateTime;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @OnDelete(action = OnDeleteAction.SET_NULL) 
    // ^ Safeguard: Clears the connection link but preserves the timestamp metrics if a student is purged after 5 years
    private Student student;

    @Column(name = "timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    @Column(name = "direction", length = 10, nullable = false)
    private String direction; // IN or OUT

    // Constructors
    public Log() {}

    public Log(Student student, String direction) {
        this.student = student;
        this.direction = direction;
    }

    // Getters and Setters
    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }
}
