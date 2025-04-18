package com.wecp.springinsurancemanagementapplication.repository;


import com.wecp.springinsurancemanagementapplication.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long>  {
    // extent jpa repository
}