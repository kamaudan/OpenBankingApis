package com.openbanking.transactions.models.dto.openbank;

import lombok.Data;

@Data
public class TransactionDetails {
    private String type;
    private String description;
    private MonetaryAmount value;
}
