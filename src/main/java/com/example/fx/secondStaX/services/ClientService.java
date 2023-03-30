package com.example.fx.secondStaX.services;

import com.example.fx.secondStaX.dtos.requests.BankAccountRequestDto;
import com.example.fx.secondStaX.dtos.requests.ClientRequestDto;
import com.example.fx.secondStaX.dtos.response.ClientResponseDto;
import com.example.fx.secondStaX.model.Client;

import java.util.List;

public interface ClientService {
    ClientResponseDto saveClient(ClientRequestDto client);

    ClientResponseDto updateClient(Long id, ClientRequestDto client);

    void deleteClient(Long id);

    ClientResponseDto getClientById(Long id);

    List<ClientResponseDto> getAllClients();

    String addBankAccount(Long id, BankAccountRequestDto bankAccountRequest);
}
