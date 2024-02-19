package com.example.bankingwork.controllers;

import com.example.bankingwork.models.Customer;
import com.example.bankingwork.models.Passport;
import com.example.bankingwork.service.CustomerService;
import com.example.bankingwork.service.PassportService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BankingWorkController {

    private CustomerService customerService;

    private PassportService passportService;


    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/passport/{id}")
    public Optional<Passport> getPassportById(@PathVariable Long id){
        return passportService.getPassportById(id);
    }

}
