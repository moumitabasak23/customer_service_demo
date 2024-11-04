package com.talcott.project.demo.service;

import com.talcott.project.demo.model.CustomerDetails;
import com.talcott.project.demo.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Objects;

@EnableTransactionManagement
@Service
public class CustomerService {

    Logger logger = LogManager.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository custRepo;

    @Transactional
    public ResponseEntity<String> saveCustomer(CustomerDetails customerDetails) {
        logger.info(" In saveCustomer method in CustomerService customerDetails ::", customerDetails);
        CustomerDetails custDetail = (CustomerDetails) custRepo.save(customerDetails);
        if (Objects.nonNull(custDetail) && custDetail.getId() != null) {
            return new ResponseEntity<>(custDetail.getId().toString(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Object is not Created", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Transactional
    public ResponseEntity<Object> fetchCustomerById(Long id) {
        CustomerDetails customerDetails = custRepo.findById(id).isPresent() ? (CustomerDetails) custRepo.findById(id).get() : null;
        logger.info("In fetchCustomerById method in CustomerService customerDetails ::", customerDetails);
        if (Objects.nonNull(customerDetails)) {
            return new ResponseEntity<>(customerDetails, HttpStatus.OK);
        }
        logger.error("Id Not Found");
        return new ResponseEntity<>("Id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @Transactional
    public ResponseEntity<List<CustomerDetails>> fetchCustomers() {
        List<CustomerDetails> custDetailsList = custRepo.findAll();
        if (custDetailsList != null && !custDetailsList.isEmpty()) {
            return new ResponseEntity<>(custDetailsList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
