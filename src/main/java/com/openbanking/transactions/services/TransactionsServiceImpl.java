package com.openbanking.transactions.services;

import com.openbanking.transactions.components.OpenBankTransactionToTransactionConverter;
import com.openbanking.transactions.models.Transaction;
import com.openbanking.transactions.models.TransactionType;
import com.openbanking.transactions.models.dto.openbank.OpenBankTransactionsWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@PropertySource("classpath:application.properties")
@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Value("${opb.api.transactions-url}")
    private String openBankTransactionUrl;

    private OpenBankTransactionToTransactionConverter opBTransactionToTransactionConverter;
    private RestTemplate openBankRestTemplate;

    public TransactionsServiceImpl(OpenBankTransactionToTransactionConverter opBTransactionConverter,
                                   RestTemplate restTemplate) {
        this.opBTransactionToTransactionConverter = opBTransactionConverter;
        this.openBankRestTemplate = restTemplate;
    }

    @Override
    public List<Transaction> queryTransactions() {
        ResponseEntity<OpenBankTransactionsWrapper> response = openBankRestTemplate.getForEntity(
                openBankTransactionUrl,
                OpenBankTransactionsWrapper.class);

        return response.getBody()
                .getTransactions()
                .stream()
                .map(opBTx -> opBTransactionToTransactionConverter.convert(opBTx))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> queryTransactionsByType(TransactionType transactionType) {
        return null;
    }

    @Override
    public BigDecimal queryTotalByTransactionType(TransactionType transactionType) {
        return null;
    }
}
