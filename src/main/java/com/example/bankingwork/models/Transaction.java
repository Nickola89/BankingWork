package com.example.bankingwork.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions", schema = "transactiondata")
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

    @Column(name = "recepient_account_id")
    @Comment("идентификатор банковского счета, " +
            "на который производится транзакция.")
    private Long recepientAccountId;

    @Column(name = "transaction_amount")
    @Comment("Сумма транзакции")
    private Long transactionAmount;

    @Column(name = "date_time_transaction")
    @Comment("дата и время проведения транзакции")
    private LocalDateTime dateTimeTransaction;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)// Указываем Hibernate, что значение этого поля должно быть сохранено в базе данных в виде строки, соответствующей имени элемента перечисления
    private TransactionType transactionType;

//    private String description;

}
