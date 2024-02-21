package com.example.bankingwork.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "cash")
    private BigDecimal cash;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

//    private  Boolean clientActivityStatus;



}
