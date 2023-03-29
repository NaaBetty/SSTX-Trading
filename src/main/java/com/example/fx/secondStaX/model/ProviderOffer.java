package com.example.fx.secondStaX.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name = "provider_offer")
public class ProviderOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rate;

    private String currency;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @OneToMany(mappedBy = "trade", cascade = CascadeType.ALL)
    private List<Trade> trades;

    public ProviderOffer() {

    }

    public ProviderOffer(Double rate, String currency, Provider provider) {
        this.rate = rate;
        this.currency = currency;
        this.provider = provider;
    }


    @Override
    public String toString() {
        return "ProviderOffer{" +
                "id=" + id +
                ", rate=" + rate +
                ", currency='" + currency + '\'' +
                ", provider=" + provider.getName() +
                '}';
    }
}
