package com.soska.myapi.dto;

import java.math.BigDecimal;

public class AccountDto {

    private BigDecimal accountBalance;

    public AccountDto() {
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}