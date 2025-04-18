package com.demo.Springboot_college.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String courseTaken;
    private int marks;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    @JsonBackReference
    private College college;

    // Getters and Setters
    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id; 
    }
    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }
    public String getCourseTaken() { 
    	return courseTaken; 
    }
    public void setCourseTaken(String courseTaken) { 
    	this.courseTaken = courseTaken; 
    }
    public int getMarks() { 
    	return marks; 
    }
    public void setMarks(int marks) { 
    	this.marks = marks; 
    }
    public College getCollege() { 
    	return college; 
    }
    public void setCollege(College college) { 
    	this.college = college; 
    }
}
