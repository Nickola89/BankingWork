package com.example.bankingwork.service;
import com.example.bankingwork.models.Account;
import com.example.bankingwork.models.Customer;
import com.example.bankingwork.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountServiceTest {
    private AccountService accountService;
    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void testCreateAccount() {
        // Arrange
        Customer customer = new Customer();
        customer.setCash(BigDecimal.valueOf(1000));

        Random random = new Random();
        Long randomNumber = Math.abs(random.nextLong()) / 2;

        LocalDateTime openingDate = LocalDateTime.now().withNano(0);

        Account expectedAccount = Account.builder()
                .accountNumber(randomNumber)
                .balance(customer.getCash())
                .openingDate(openingDate)
                .customer(customer)
                .build();

        when(accountRepository.save(any(Account.class))).thenReturn(expectedAccount);

        // Act
        Account createdAccount = accountService.create(customer);

        // Assert
        assertEquals(expectedAccount, createdAccount);
        verify(accountRepository, times(1)).save(any(Account.class));
    }
    }
