package com.example.fx.secondStaX.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rate")
    private Double rate;
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Trade> trades;

    @Column(name = "offers")
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<ProviderOffer> providerOffers;

    public Provider() {}

    public Provider(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }

}
