package com.dormflow.dorm_flow_backend.entity;

import com.dormflow.dorm_flow_backend.enums.StudentStatus;
import com.dormflow.dorm_flow_backend.enums.MovementStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "student",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_student_student_id", columnNames = "student_id")
    }
)
public class Student {

    @Id
    @Column(name = "student_id", length = 50, nullable = false, updatable = false)
    private String studentId;

    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "faculty", length = 150)
    private String faculty;

    @Column(name = "academic_year")
    private Integer academicYear;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "emergency_contact_name", length = 150)
    private String emergencyContactName;

    @Column(name = "emergency_contact_number", length = 20)
    private String emergencyContactNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "allocation_start_date")
    private LocalDate allocationStartDate;

    @Column(name = "allocation_end_date")
    private LocalDate allocationEndDate;

    @Column(name = "photo_object_key", length = 500)
    private String photoObjectKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StudentStatus status = StudentStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_status", nullable = false, length = 10)
    private MovementStatus movementStatus = MovementStatus.OUT;

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getAllocationStartDate() {
        return allocationStartDate;
    }

    public void setAllocationStartDate(LocalDate allocationStartDate) {
        this.allocationStartDate = allocationStartDate;
    }

    public LocalDate getAllocationEndDate() {
        return allocationEndDate;
    }

    public void setAllocationEndDate(LocalDate allocationEndDate) {
        this.allocationEndDate = allocationEndDate;
    }

    public String getPhotoObjectKey() {
        return photoObjectKey;
    }

    public void setPhotoObjectKey(String photoObjectKey) {
        this.photoObjectKey = photoObjectKey;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public MovementStatus getMovementStatus() {
        return movementStatus;
    }

    public void setMovementStatus(MovementStatus movementStatus) {
        this.movementStatus = movementStatus;
    }
}