package com.demo.Springboot_college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Springboot_college.entity.College;
import com.demo.Springboot_college.entity.Student;
import com.demo.Springboot_college.service.CollegeService;

@RestController
@RequestMapping("/colleges")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College savedCollege = collegeService.createCollege(college);
        return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
    }

    @PostMapping("/{collegeId}/students")
    public ResponseEntity<Student> createStudent(@PathVariable Long collegeId,@RequestBody Student student) {
        Student savedStudent = collegeService.createStudent(collegeId, student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = collegeService.getAllColleges();
        return new ResponseEntity<>(colleges, HttpStatus.PARTIAL_CONTENT);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudentsByCollegeName(@RequestParam String collegeName) {
        List<Student> students = collegeService.getStudentsByCollegeName(collegeName);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
