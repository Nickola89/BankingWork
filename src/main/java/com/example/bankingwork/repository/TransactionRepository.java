package com.example.bankingwork.repository;

import com.example.bankingwork.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
