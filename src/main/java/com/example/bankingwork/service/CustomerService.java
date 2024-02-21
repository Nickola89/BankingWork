package com.example.bankingwork.service;

import com.example.bankingwork.exceptions.NoSuchCustomerException;
import com.example.bankingwork.models.Customer;
import com.example.bankingwork.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }
    @SneakyThrows
    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow(()-> new NoSuchCustomerException("There is no customer with id: " + id + " in database"));
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer update(Customer customer, Long id){
       Customer optionalSave = findById(id);
        Customer customer1;
        if (optionalSave == null) {
            return optionalSave;
        } else {
            customer1 = optionalSave;
        }
        if (customer.getName()!=null){
            customer1.setName(customer.getName());
        }
        if (customer.getLastName()!=null){
            customer1.setLastName(customer.getLastName());
        }
        if (customer.getAge()!= 0){
            customer1.setAge(customer.getAge());
        }
        if (customer.getAddress()!=null){
            customer1.setAddress(customer.getAddress());
        }
        if (customer.getPhoneNumber()!=null){
            customer1.setPhoneNumber(customer.getPhoneNumber());
        }
        if (customer.getEmail()!=null){
            customer1.setEmail(customer.getEmail());
        }
        if (customer.getBirthday()!=null){
            customer1.setBirthday(customer.getBirthday());
        }
        if (customer.getRegistrationDate()!=null){
            customer1.setRegistrationDate(customer.getRegistrationDate());
        }
        return customerRepository.save(customer1);
    }
    public Optional<Customer> delete(Long id){
         customerRepository.deleteById(id);
         return Optional.empty();
    }
}
