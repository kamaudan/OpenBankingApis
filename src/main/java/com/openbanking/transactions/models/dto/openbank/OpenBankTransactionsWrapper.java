package com.openbanking.transactions.models.dto.openbank;

import lombok.Data;

import java.util.List;

@Data
public class OpenBankTransactionsWrapper {
    private List<OpenBankTransaction> transactions;
}
