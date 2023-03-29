package com.example.fx.secondStaX.contollers;

import com.example.fx.secondStaX.model.BankAccount;
import com.example.fx.secondStaX.model.Client;
import com.example.fx.secondStaX.model.ProviderOffer;
import com.example.fx.secondStaX.repositories.ClientRequestRepository;
import com.example.fx.secondStaX.services.BankAccountService;
import com.example.fx.secondStaX.services.ProviderOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client/request")
public class ClientRequestController {

    @Autowired
    private ClientRequestRepository clientRequestRepository;

    @Autowired
    private ProviderOfferService providerOfferService;

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<Client> createClientRequest(@RequestBody Client client) {
        // Save the client request to the database
        client.setStatus("PENDING");
        Client savedClient = clientRequestRepository.save(client);

        // Return the saved client request
        return ResponseEntity.ok(savedClient);
    }

    @GetMapping("/{id}/provider")
    public ResponseEntity<List<ProviderOffer>> getProviderOffers(@PathVariable Long id) {
        // Get the client request from the database
        Optional<Client> optionalClientRequest = clientRequestRepository.findById(id);
        if (optionalClientRequest.isPresent()) {
            Client client = optionalClientRequest.get();

            // Get the provider offers using the providerOfferService
            List<ProviderOffer> providerOffers = providerOfferService.getProviderOffers(client.getAmount(), client.getCurrency());

            // Return the provider offers
            return ResponseEntity.ok(providerOffers);
        } else {
            // Client request not found
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/provider")
    public ResponseEntity<Client> updateProvider(@PathVariable Long id, @RequestParam Long providerId) {
        // Get the client request from the database
        Optional<Client> optionalClientRequest = clientRequestRepository.findById(id);
        if (optionalClientRequest.isPresent()) {
            Client client = optionalClientRequest.get();

            // Update the provider for the client request
            Optional<ProviderOffer> optionalProviderOffer = providerOfferService.getProviderOffer(providerId);
            if (optionalProviderOffer.isPresent()) {

                // Update the client request in the database
                Client updatedClient = clientRequestRepository.save(client);

                // Return the updated client request
                return ResponseEntity.ok(updatedClient);
            } else {
                // Provider not found
                return ResponseEntity.notFound().build();
            }
        } else {
            // Client request not found
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/bank-account")
    public ResponseEntity<Client> updateBankAccount(@PathVariable Long id, @RequestParam Long bankAccountId) {
        // Get the client request from the database
        Optional<Client> optionalClientRequest = clientRequestRepository.findById(id);
        if (optionalClientRequest.isPresent()) {
            Client client = optionalClientRequest.get();

            // Update the bank account for the client request
            Optional<BankAccount> optionalBankAccount = bankAccountService.getBankAccount(bankAccountId);
            if (optionalBankAccount.isPresent()) {
                client.setBankAccount(optionalBankAccount.get());

                Client updatedClient = clientRequestRepository.save(client);

                return ResponseEntity.ok(updatedClient);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

