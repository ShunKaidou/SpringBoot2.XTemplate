package com.demo.Springboot_college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Springboot_college.entity.College;
import com.demo.Springboot_college.entity.Student;
import com.demo.Springboot_college.repository.CollegeRepository;
import com.demo.Springboot_college.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private StudentRepository studentRepository;

    public College createCollege(College college) {
        return collegeRepository.save(college);
    }

    public Student createStudent(Long collegeId, Student student) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new EntityNotFoundException("College not found"));
        student.setCollege(college);
        return studentRepository.save(student);
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public List<Student> getStudentsByCollegeName(String collegeName) {
        return studentRepository.findByCollege_NameOrderByNameDesc(collegeName);
    }
}
