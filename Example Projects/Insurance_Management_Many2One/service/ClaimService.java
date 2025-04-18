package com.wecp.springinsurancemanagementapplication.service;


import com.wecp.springinsurancemanagementapplication.entity.Claim;
import com.wecp.springinsurancemanagementapplication.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public Claim fileClaim(Claim claim) {
        // add claim to database
        return claimRepository.save(claim);
    }

    public List<Claim> getAllClaims() {
       // get all claims from database
       return claimRepository.findAll();
    }
}