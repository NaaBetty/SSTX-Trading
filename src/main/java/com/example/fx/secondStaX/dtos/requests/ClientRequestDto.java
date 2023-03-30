package com.example.fx.secondStaX.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
public class ClientRequestDto {
    private String name;
    private String email;
    private String password;
    private BankAccountRequestDto bankAccount;

    public Optional<BankAccountRequestDto> getBankAccount() {
        return Optional.ofNullable(bankAccount);
    }
}
