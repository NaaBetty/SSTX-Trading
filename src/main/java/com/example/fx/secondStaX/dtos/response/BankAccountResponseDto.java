package com.example.fx.secondStaX.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankAccountResponseDto {
    private String accountNumber;
    private String bankName;
    private BigDecimal accountBalance;
}
