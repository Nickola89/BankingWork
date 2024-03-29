package com.example.bankingwork.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sender_account_id")
    @Comment("идентификатор банковского счета, " +
            "с которого производится транзакция.")
    private Long senderAccountId;

    @Column(name = "recipient_account_id")
    @Comment("идентификатор банковского счета, " +
            "на который производится транзакция.")
    private Long recipientAccountId;

    @Column(name = "transaction_amount")
    @Comment("Сумма транзакции")
    private BigDecimal transactionAmount;

    @Column(name = "date_time_transaction")
    @Comment("дата и время проведения транзакции")
    private LocalDateTime dateTimeTransaction;

    @Column(name = "transaction_type")
    private String transactionType;

//    private String description;

}
