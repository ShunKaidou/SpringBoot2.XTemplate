package com.wecp.springinsurancemanagementapplication.entity;


import javax.persistence.*;

import java.util.Date;

@Entity
public class Claim {
    // implement entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    @Column(unique = true)
    private String claimNumber;

    private Date claimDate;
    private double claimAmount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    public Claim() {
    }

    public Claim(String claimNumber, Date claimDate, double claimAmount, String description, Policy policy) {
        this.claimNumber = claimNumber;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
        this.policy = policy;
    }

    public Claim(Long claimId, String claimNumber, Date claimDate, double claimAmount, String description,
            Policy policy) {
        this.claimId = claimId;
        this.claimNumber = claimNumber;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
        this.policy = policy;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

}