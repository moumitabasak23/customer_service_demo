package com.talcott.project.demo.repository;

import com.talcott.project.demo.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails,Long> {
}
