package com.openbanking.transactions.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Transaction {
    private String id;
    private String accountId;
    private String counterPartyAccount;
    private String counterPartyName;
    private String counterPartyLogoPath;
    private BigDecimal instructedAmount;
    private String instructedCurrency;
    private BigDecimal transactionAmount;
    private String transactionCurrency;
    private String transactionType;
    private String description;
}

