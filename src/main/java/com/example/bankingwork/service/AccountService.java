package com.example.bankingwork.service;

import com.example.bankingwork.models.Account;
import com.example.bankingwork.models.Customer;
import com.example.bankingwork.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@Transactional
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public Account create(Customer customer) {
        Random random = new Random();
        Long randomNumber = Math.abs(random.nextLong())/2;
        System.out.println(randomNumber);
        LocalDateTime openingDate = LocalDateTime.now();


        Account account = Account.builder()
                .accountNumber(randomNumber)
                .balance(customer.getCash())
                .openingDate(openingDate)
                .build();

        account.setCustomer(customer);

        return accountRepository.save(account);
    }
}
