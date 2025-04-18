package com.demo.Springboot_college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Springboot_college.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {}
