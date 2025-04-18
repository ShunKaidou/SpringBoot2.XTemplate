package com.wecp.springinsurancemanagementapplication.controller;


import com.wecp.springinsurancemanagementapplication.entity.Claim;
import com.wecp.springinsurancemanagementapplication.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public Claim fileClaim(@RequestBody Claim claim) {
       // file a claim
       return claimService.fileClaim(claim);
    }


    @GetMapping
    public List<Claim> getAllClaims() {
      // get all claims
      return claimService.getAllClaims();
    }
}