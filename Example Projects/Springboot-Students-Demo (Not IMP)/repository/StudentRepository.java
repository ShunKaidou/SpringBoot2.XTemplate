package com.demo.springboot_students_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot_students_demo.entity.Student;
import com.demo.springboot_students_demo.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
