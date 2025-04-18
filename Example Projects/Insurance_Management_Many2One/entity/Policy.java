package com.wecp.springinsurancemanagementapplication.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Policy {

   // implement entity
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long policyId;

   @Column(unique = true)
   private String policyNumber;

   private String type;

   private double coverageAmount;

   private double premium;

   private String holderName;

   private String holderAddress;

   private String holderContactNumber;

   private String holderEmail;

   @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
   @JsonIgnore(value = true)
   private List<Claim> claims = new ArrayList<>();

   public Policy() {
   }

   public Policy(String policyNumber, String type, double coverageAmount, double premium, String holderName,
         String holderAddress, String holderContactNumber, String holderEmail, List<Claim> claims) {
      this.policyNumber = policyNumber;
      this.type = type;
      this.coverageAmount = coverageAmount;
      this.premium = premium;
      this.holderName = holderName;
      this.holderAddress = holderAddress;
      this.holderContactNumber = holderContactNumber;
      this.holderEmail = holderEmail;
   }

   public Policy(Long policyId, String policyNumber, String type, double coverageAmount, double premium,
         String holderName, String holderAddress, String holderContactNumber, String holderEmail, List<Claim> claims) {
      this.policyId = policyId;
      this.policyNumber = policyNumber;
      this.type = type;
      this.coverageAmount = coverageAmount;
      this.premium = premium;
      this.holderName = holderName;
      this.holderAddress = holderAddress;
      this.holderContactNumber = holderContactNumber;
      this.holderEmail = holderEmail;
   }

   public Long getPolicyId() {
      return policyId;
   }

   public void setPolicyId(Long policyId) {
      this.policyId = policyId;
   }

   public String getPolicyNumber() {
      return policyNumber;
   }

   public void setPolicyNumber(String policyNumber) {
      this.policyNumber = policyNumber;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public double getCoverageAmount() {
      return coverageAmount;
   }

   public void setCoverageAmount(double coverageAmount) {
      this.coverageAmount = coverageAmount;
   }

   public double getPremium() {
      return premium;
   }

   public void setPremium(double premium) {
      this.premium = premium;
   }

   public String getHolderName() {
      return holderName;
   }

   public void setHolderName(String holderName) {
      this.holderName = holderName;
   }

   public String getHolderAddress() {
      return holderAddress;
   }

   public void setHolderAddress(String holderAddress) {
      this.holderAddress = holderAddress;
   }

   public String getHolderContactNumber() {
      return holderContactNumber;
   }

   public void setHolderContactNumber(String holderContactNumber) {
      this.holderContactNumber = holderContactNumber;
   }

   public String getHolderEmail() {
      return holderEmail;
   }

   public void setHolderEmail(String holderEmail) {
      this.holderEmail = holderEmail;
   }

   public List<Claim> getClaims() {
      return claims;
   }

   public void setClaims(List<Claim> claims) {
      this.claims = claims;
   }

   
}