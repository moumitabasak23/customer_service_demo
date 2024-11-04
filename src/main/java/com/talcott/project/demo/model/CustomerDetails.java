package com.talcott.project.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;


@Entity
@Table(name = "customers")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(name = "cust_name")
    private String customerName;

    @Column(name = "cust_address")
    private String address;

    @Nonnull
    @Column(name = "cust_contact")
    private int contactNumber;

    @Column(name = "cust_email_id")
    private String emailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
