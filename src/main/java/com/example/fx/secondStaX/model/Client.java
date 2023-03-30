package com.example.fx.secondStaX.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "client_request")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "display_id")
    private String displayId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<BankAccount> bankAccount;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Trade> trade;

    @Column(nullable = false, name = "is_active")
    private boolean isActive;

}
