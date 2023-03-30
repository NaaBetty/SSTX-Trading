package com.example.fx.secondStaX.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankAccountRequestDto {
    private String accountNumber;
    private String bankName;
    private Long clientId;
    private BigDecimal accountBalance;
}
