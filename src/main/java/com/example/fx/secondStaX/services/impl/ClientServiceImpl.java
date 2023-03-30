package com.example.fx.secondStaX.services.impl;

import com.example.fx.secondStaX.dtos.requests.BankAccountRequestDto;
import com.example.fx.secondStaX.dtos.requests.ClientRequestDto;
import com.example.fx.secondStaX.dtos.response.ClientResponseDto;
import com.example.fx.secondStaX.model.BankAccount;
import com.example.fx.secondStaX.model.Client;
import com.example.fx.secondStaX.repositories.BankAccountRepository;
import com.example.fx.secondStaX.repositories.ClientRequestRepository;
import com.example.fx.secondStaX.services.ClientService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRequestRepository clientRepository;

    @Autowired
    private BankAccountService bankAccountService;

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public ClientResponseDto saveClient(ClientRequestDto request) {
        Validate.notNull(request, "request object cannot be null");
        Client client = Client.builder()
                              .email(request.getEmail())
                              .name(request.getName())
                              .displayId(UUID.randomUUID().toString().substring(1, 5))
                              .password(request.getPassword())
                              .isActive(true)
                              .build();

        return mapper.map(clientRepository.save(client), ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto updateClient(Long id, ClientRequestDto request) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No matching records for supplied ID: " + id));
        client.setName(request.getName());
        client.setEmail(request.getEmail());

        return mapper.map(clientRepository.save(client), ClientResponseDto.class);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No matching records for supplied ID: " + id));
        client.setActive(false);
        clientRepository.save(client);
    }

    @Override
    public ClientResponseDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No matching records for supplied ID: " + id));
        return mapper.map(client, ClientResponseDto.class);
    }

    @Override
    public List<ClientResponseDto> getAllClients() {
        return clientRepository.findAll()
                            .stream()
                            .map(client -> mapper.map(client, ClientResponseDto.class))
                            .collect(Collectors.toList());
    }

    @Override
    public String addBankAccount(Long id, BankAccountRequestDto bankAccountRequest) {
        Validate.notNull(bankAccountRequest, "bank account details should not be null");

        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No matching records for supplied ID: " + id));
        BankAccount bankAccount = BankAccount.builder()
                                        .accountNumber(bankAccountRequest.getAccountNumber())
                                        .client(client)
                                        .bankName(bankAccountRequest.getBankName())
                                        .accountBalance(bankAccountRequest.getAccountBalance())
                                        .build();
        bankAccountRepository.save(bankAccount);
        return bankAccount.getAccountNumber();
    }
}
