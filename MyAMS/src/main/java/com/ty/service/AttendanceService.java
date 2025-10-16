package com.ty.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ty.model.EmployeeAttendance;
import com.ty.repository.AttendanceRepository;

@Service
public class AttendanceService {
	    @Autowired
	    private AttendanceRepository repository;

	   
	    public String saveAttendance(String employeeName, String qrCodeData, boolean casualLeave, MultipartFile selfie) throws IOException {
	        EmployeeAttendance attendance = new EmployeeAttendance();
	        attendance.setEmployeeName(employeeName);
	        attendance.setQrCodeData(qrCodeData);
	        attendance.setTimestamp(LocalDateTime.now());
	        attendance.setSelfie(selfie.getBytes());
	        attendance.setCasualLeave(casualLeave);

	        repository.save(attendance);
	        return "Attendance Saved Successfully";
	    }

	
	    public List<EmployeeAttendance> getAllAttendances() {
	        return repository.findAll();
	    }
}



