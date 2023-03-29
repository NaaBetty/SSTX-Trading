package com.example.fx.secondStaX.repositories;

import com.example.fx.secondStaX.model.ProviderOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderOfferRepository extends JpaRepository<ProviderOffer, Long> {
}