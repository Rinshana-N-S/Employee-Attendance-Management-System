package com.ty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.model.EmployeeAttendance;

public interface AttendanceRepository extends JpaRepository<EmployeeAttendance, Long>{

}
