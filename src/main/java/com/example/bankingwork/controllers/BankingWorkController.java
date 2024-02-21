package com.example.bankingwork.controllers;

import com.example.bankingwork.exceptions.NoSuchCustomerException;
import com.example.bankingwork.models.Account;
import com.example.bankingwork.models.Customer;
import com.example.bankingwork.models.Passport;
import com.example.bankingwork.service.AccountService;
import com.example.bankingwork.service.CustomerService;
import com.example.bankingwork.service.PassportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BankingWorkController {

    private CustomerService customerService;
    private PassportService passportService;
    private AccountService accountService;


    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/passport/{id}")
    public Optional<Passport> getPassportById(@PathVariable Long id){
        return passportService.getPassportById(id);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        customerService.create(customer);
        accountService.create(customer);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
        customerService.update(customer, id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            throw new NoSuchCustomerException("There is no customer with Id = " + id + " in database");
        }
        customerService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
