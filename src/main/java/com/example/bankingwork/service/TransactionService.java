package com.example.bankingwork.service;

import com.example.bankingwork.models.Transaction;
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


    public Transaction create(Transaction tran){
        LocalDateTime transactionTime = LocalDateTime.now().withNano(0);
           Transaction transaction = Transaction.builder()
                .senderAccountId(tran.getSenderAccountId())
                .recipientAccountId(tran.getRecipientAccountId())
                .transactionAmount(tran.getTransactionAmount())
                .dateTimeTransaction(transactionTime)
                .transactionType(tran.getTransactionType())
                .build();
        return transactionRepository.save(transaction);
    }

    public Transaction topUpAccount(Transaction tran){
        LocalDateTime transactionTime = LocalDateTime.now().withNano(0);
        Transaction transaction = Transaction.builder()
                .senderAccountId(tran.getSenderAccountId())
                .transactionAmount(tran.getTransactionAmount())
                .transactionType(tran.getTransactionType())
                .dateTimeTransaction(transactionTime)
                .build();
        return transactionRepository.save(transaction);
    }
}
