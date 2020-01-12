package com.openbanking.transactions.models.dto.openbank;

import lombok.Data;

@Data
public class MonetaryAmount {
    private String currency;
    private String amount;
}