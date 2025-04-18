package com.demo.Springboot_college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Springboot_college.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCollege_NameOrderByNameDesc(String collegeName);
}
