package com.wecp.empwellbeingapplication.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
   // implement entity here

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long employeeId;

   private String fullName;
   private Date dateOfBirth;
   private String email;
   private String healthStatus;

   @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
   @JsonIgnore
   private List<Program> program = new ArrayList<>();

   public Employee() {
   }

   public Employee(Long employeeId, String fullName, Date dateOfBirth, String email, String healthStatus,
         List<Program> program) {
      this.employeeId = employeeId;
      this.fullName = fullName;
      this.dateOfBirth = dateOfBirth;
      this.email = email;
      this.healthStatus = healthStatus;
      this.program = program;
   }

   public Employee(String fullName, Date dateOfBirth, String email, String healthStatus, List<Program> program) {
      this.fullName = fullName;
      this.dateOfBirth = dateOfBirth;
      this.email = email;
      this.healthStatus = healthStatus;
      this.program = program;
   }

   public Long getEmployeeId() {
      return employeeId;
   }

   public void setEmployeeId(Long employeeId) {
      this.employeeId = employeeId;
   }

   public String getFullName() {
      return fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   public Date getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getHealthStatus() {
      return healthStatus;
   }

   public void setHealthStatus(String healthStatus) {
      this.healthStatus = healthStatus;
   }

   public List<Program> getProgram() {
      return program;
   }

   public void setProgram(List<Program> program) {
      this.program = program;
   }

   
}