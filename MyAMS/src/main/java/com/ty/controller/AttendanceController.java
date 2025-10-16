
package com.ty.controller;

import com.ty.model.EmployeeAttendance;
import com.ty.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") 
public class AttendanceController {

    @Autowired
    private AttendanceRepository repository;

    @PostMapping(value = "/attendance", consumes = "multipart/form-data")
    public ResponseEntity<?> saveAttendance(
            @RequestParam("employeeName") String employeeName,
            @RequestParam("qrCodeData") String qrCodeData,
            @RequestParam("selfie") MultipartFile selfie,
            @RequestParam("date") String date,
            @RequestParam(value = "casualLeave", required = false, defaultValue = "false") boolean casualLeave
    ) throws IOException {
        EmployeeAttendance attendance = new EmployeeAttendance();
        attendance.setEmployeeName(employeeName);
        attendance.setQrCodeData(qrCodeData);
        attendance.setSelfie(selfie.getBytes());
        attendance.setCasualLeave(casualLeave);
        attendance.setTimestamp(LocalDateTime.now());

        
        try {
            LocalDate parsedDate = LocalDate.parse(date.substring(0, 10)); 
            attendance.setPresentDate(parsedDate);
        } catch (Exception e) {
            attendance.setPresentDate(LocalDate.now()); 
        }

        repository.save(attendance);
        return ResponseEntity.ok().body("{\"message\": \"Attendance saved successfully\"}");
    }

    @GetMapping("/attendance")
    public List<EmployeeAttendance> getAllAttendances() {
        return repository.findAll();
    }
    @GetMapping("/attendance-list")
    public String viewAttendanceList(Model model) {
        List<EmployeeAttendance> attendances = repository.findAll();
        model.addAttribute("attendances", attendances);
        return "attendance-list"; 
        
    }

}
