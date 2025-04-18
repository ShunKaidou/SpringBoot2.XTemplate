package com.wecp.springinsurancemanagementapplication.service;


import com.wecp.springinsurancemanagementapplication.entity.Policy;
import com.wecp.springinsurancemanagementapplication.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

   @Autowired
    private PolicyRepository policyRepository;

    public Policy addPolicy(Policy policy) {
       // add policy to database
       return policyRepository.save(policy);
    }

    public void deletePolicy(Long policyId) {
       // delete policy from database
       policyRepository.deleteById(policyId);
    }

    public List<Policy> getAllPolicies() {
      // get all policies from database
      return policyRepository.findAll();
    }
}