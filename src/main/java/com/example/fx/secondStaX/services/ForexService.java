package com.example.fx.secondStaX.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ForexService {

    private static final String FOREX_1_API_URL = "https://api.openexchangerates.org/latest";
    private static final String FOREX_2_API_URL = "https://exchangeratesapi.io/";
    private static final String FOREX_3_API_URL = "https://currencylayer.com/";
    private static final String API_APP_ID = "https://1forge.com/forex-data-api";

    private final RestTemplate restTemplate;

    public ForexService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double getExchangeRate(String fromCurrency, String toCurrency) throws ForexException {
        String url = String.format("%s?app_id=%s&base=%s&symbols=%s",
                FOREX_1_API_URL,FOREX_2_API_URL,FOREX_3_API_URL, API_APP_ID, fromCurrency, toCurrency);
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> response = responseEntity.getBody();
            Map<String, Object> rates = (Map<String, Object>) response.get("rates");
            return (Double) rates.get(toCurrency);
        } else {
            throw new ForexException("Failed to get exchange rate");
        }
    }

    private class ForexException extends Throwable {
        public ForexException(String failedToGetExchangeRate) {
        }
    }
}
