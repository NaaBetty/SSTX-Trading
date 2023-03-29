package com.example.fx.secondStaX.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    public BankAccount() {
    }

    public BankAccount(String name, String accountNumber, String bankName) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

}