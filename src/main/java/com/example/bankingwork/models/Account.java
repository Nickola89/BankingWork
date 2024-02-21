package com.example.bankingwork.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*Банковский счет клиента*/
@Entity
@Table(name = "accounts", schema = "transactiondata")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    @Comment("уникальный номер банковского счета")
    private Long accountNumber;

    @Comment("идентификатор клиента, " +
            "которому принадлежит счет")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "opening_date")
    @Comment("дата открытия счета")
    private LocalDateTime openingDate;

   /* @Column(name = "closing_date")
    @Comment("дата закрытия счета")
    private LocalDateTime closingDate;*/

//  private Boolean accountActivityStatus;

}
