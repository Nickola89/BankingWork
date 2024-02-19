package com.example.bankingwork.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
@Entity
@Table(name = "passports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String number;

    @Column(name = "issuing_country")
    private String issuingCountry;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
}
