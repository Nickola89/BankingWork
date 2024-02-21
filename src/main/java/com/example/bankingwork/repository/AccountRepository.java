package com.example.bankingwork.repository;

import com.example.bankingwork.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    @Modifying
    @Query("UPDATE Account a SET a.balance = a.balance - :balance WHERE a.customer.id = :customerId")
    void decreaseBalanceByCustomerId(Long customerId, BigDecimal balance);
    @Modifying
    @Query("UPDATE Account a SET a.balance = a.balance + :balance WHERE a.customer.id = :customerId")
    void increaseBalanceByCustomerId(Long customerId, BigDecimal balance);

}
