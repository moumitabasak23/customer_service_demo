package com.talcott.project.demo.controller;

import com.talcott.project.demo.dto.CustomerDetailsDTO;
import com.talcott.project.demo.model.CustomerDetails;
import com.talcott.project.demo.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService custService;

    @PostMapping("/customer/save")
    public ResponseEntity<String> saveCustomerDetails(@RequestBody CustomerDetails custDetailDto) {
        logger.info("In saveCustomerDetails method in CustomerController custDetailsDto :: ", custDetailDto.toString());
        return custService.saveCustomer(custDetailDto);
    }

    @PutMapping("/customer/update")
    public ResponseEntity<String> updateCustomerDetails(@RequestBody CustomerDetails custDetailDto) {
        logger.info("In updateCustomerDetails method in CustomerController custDetailsDto :: ", custDetailDto.toString());
        return custService.updateCustomer(custDetailDto);
    }

    @DeleteMapping("/customer/delete/{id}")
    public void deleteCustomerDetails(@PathVariable Long id) {
        logger.info("In deleteCustomerDetails method in CustomerController id :: ", id);
        custService.deleteCustomer(id);
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> fetchCustomerById(@PathVariable Long id) {
        logger.info("In fetchCustomerById method in CustomerController id :: ", id);
        return custService.fetchCustomerById(id);
    }

    @GetMapping("/customers/all")
    public ResponseEntity<List<CustomerDetails>> fetchCustomers() {
        logger.info("In fetchCustomers method in CustomerController");
        return custService.fetchCustomers();
    }
}
