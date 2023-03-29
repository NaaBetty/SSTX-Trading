package com.example.fx.secondStaX.services;

import com.example.fx.secondStaX.model.ProviderOffer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProviderOfferService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<ProviderOffer> getProviderOffers(Double amount, String currency) {
        List<ProviderOffer> providerOffers = new ArrayList<>();

        // Provider 1
        String url1 = "https://provider1.com/api/provider-offers?currency=" + currency;
        ResponseEntity<List<ProviderOffer>> responseEntity1 = restTemplate.exchange(
                url1,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProviderOffer>>() {});
        providerOffers.addAll(responseEntity1.getBody());

        // Provider 2
        String url2 = "https://provider2.com/api/provider-offers?currency=" + currency;
        ResponseEntity<List<ProviderOffer>> responseEntity2 = restTemplate.exchange(
                url2,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProviderOffer>>() {});
        providerOffers.addAll(responseEntity2.getBody());

        // Provider 3
        String url3 = "https://provider3.com/api/provider-offers?currency=" + currency;
        ResponseEntity<List<ProviderOffer>> responseEntity3 = restTemplate.exchange(
                url3,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProviderOffer>>() {});
        providerOffers.addAll(responseEntity3.getBody());

        return providerOffers;
    }

    public Optional<ProviderOffer> getProviderOffer(Long id) {
        String url = "https://example.com/api/provider-offers/" + id;
        ResponseEntity<ProviderOffer> responseEntity = restTemplate.getForEntity(url, ProviderOffer.class);
        ProviderOffer providerOffer = responseEntity.getBody();
        return Optional.ofNullable(providerOffer);
    }

}


