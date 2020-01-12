package com.openbanking.transactions.components;

import com.openbanking.transactions.models.Transaction;
import com.openbanking.transactions.models.dto.openbank.OpenBankTransaction;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * OpenBank Transaction converter
 */
@Component
public class OpenBankTransactionToTransactionConverter implements Converter<OpenBankTransaction, Transaction> {
    @Override
    public Transaction convert(OpenBankTransaction openBankTransaction) {
        return Transaction.builder()
                .id(openBankTransaction.getId())
                .accountId(openBankTransaction.getThisAccount().getId())
                .counterPartyAccount(openBankTransaction.getOtherAccount().getNumber())
                .counterPartyName(openBankTransaction.getOtherAccount().getHolder().getName())
                .counterPartyLogoPath(openBankTransaction.getOtherAccount().getMetadata().getImageURL())
                .instructedAmount(new BigDecimal(openBankTransaction.getDetails().getValue().getAmount()))
                .instructedCurrency(openBankTransaction.getDetails().getValue().getCurrency())
                .transactionAmount(new BigDecimal(openBankTransaction.getDetails().getValue().getAmount()))
                .transactionCurrency(openBankTransaction.getDetails().getValue().getCurrency())
                .transactionType(openBankTransaction.getDetails().getType())
                .description(openBankTransaction.getDetails().getDescription())
                .build();
    }
}
