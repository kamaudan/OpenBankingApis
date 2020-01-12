package com.openbanking.transactions.models.dto.openbank;

import lombok.Data;

@Data
public class CounterPartyOpenBankAccount extends AbstractOpenBankAccount {
    private Holder holder;
    private Metadata metadata;
}
