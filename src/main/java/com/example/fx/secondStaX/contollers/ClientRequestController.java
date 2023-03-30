package com.example.fx.secondStaX.contollers;

import com.example.fx.secondStaX.dtos.requests.BankAccountRequestDto;
import com.example.fx.secondStaX.dtos.requests.ClientRequestDto;
import com.example.fx.secondStaX.dtos.response.ClientResponseDto;
import com.example.fx.secondStaX.model.Client;
import com.example.fx.secondStaX.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/client/request")
public class ClientRequestController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<ClientResponseDto> createClientRequest(@RequestBody ClientRequestDto client) {
        return new ResponseEntity<>(clientService.saveClient(client), CREATED);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<ClientResponseDto> updateClient(@PathVariable Long id, @RequestBody ClientRequestDto client) {
        return new ResponseEntity<>(clientService.updateClient(id, client), ACCEPTED);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClientById(id), OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), OK);
    }

    //set bank account
    @PutMapping("/{id}/bank-account")
    public ResponseEntity<String> addBankAccount(@PathVariable Long id, @RequestBody BankAccountRequestDto bankAccountRequest) {
        return new ResponseEntity<>("Added account: " + clientService.addBankAccount(id, bankAccountRequest), ACCEPTED);
    }
}

