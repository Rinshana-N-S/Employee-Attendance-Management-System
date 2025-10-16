/*
 * package com.ty.model;
 * 
 * import java.time.LocalDateTime;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.Lob;
 * 
 * @Entity public class EmployeeAttendance {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * private String employeeName;
 * 
 * private String qrCodeData; private LocalDateTime timestamp;
 * 
 * @Lob
 * 
 * @Column(columnDefinition = "LONGBLOB") private byte[] selfie;
 * 
 * public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public String getEmployeeName() { return employeeName; }
 * 
 * public void setEmployeeName(String employeeName) { this.employeeName =
 * employeeName; }
 * 
 * public String getQrCodeData() { return qrCodeData; }
 * 
 * public void setQrCodeData(String qrCodeData) { this.qrCodeData = qrCodeData;
 * }
 * 
 * public LocalDateTime getTimestamp() { return timestamp; }
 * 
 * public void setTimestamp(LocalDateTime timestamp) { this.timestamp =
 * timestamp; }
 * 
 * public byte[] getSelfie() { return selfie; }
 * 
 * public void setSelfie(byte[] selfie) { this.selfie = selfie; }
 * 
 * }
 */
package com.ty.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class EmployeeAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    
    private String qrCodeData;
    private LocalDateTime timestamp;
    
    @Column(nullable = false)
    private LocalDate presentDate;  // New field for the date of attendance
    
    private boolean casualLeave;    // New field to track if it's a casual leave day

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] selfie;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getQrCodeData() {
        return qrCodeData;
    }

    public void setQrCodeData(String qrCodeData) {
        this.qrCodeData = qrCodeData;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDate getPresentDate() {
        return presentDate;
    }

    public void setPresentDate(LocalDate presentDate) {
        this.presentDate = presentDate;
    }

    public boolean isCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(boolean casualLeave) {
        this.casualLeave = casualLeave;
    }

    public byte[] getSelfie() {
        return selfie;
    }

    public void setSelfie(byte[] selfie) {
        this.selfie = selfie;
    }
}