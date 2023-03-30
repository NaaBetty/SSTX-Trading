package com.example.fx.secondStaX.dtos.response;

import com.example.fx.secondStaX.dtos.requests.BankAccountRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ClientResponseDto {
    private String displayId;
    private String name;
    private String email;
    private Set<BankAccountResponseDto> bankAccount;
}
