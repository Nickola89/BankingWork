package com.example.bankingwork.service;

import com.example.bankingwork.models.Transaction;
import com.example.bankingwork.models.TransactionType;
import com.example.bankingwork.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@AllArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;

    public Transaction create(Transaction transaction){
        LocalDateTime transactionTime = LocalDateTime.now().withNano(0);
        Transaction transaction1 = Transaction.builder()
                .senderAccountId(transaction.getSenderAccountId())
                .recipientAccountId(transaction.getRecipientAccountId())
                .transactionAmount(transaction.getTransactionAmount())
                .dateTimeTransaction(transactionTime)
                .transactionType(TransactionType.TRANSFER)
                .build();
        return transactionRepository.save(transaction1);
    }
}
