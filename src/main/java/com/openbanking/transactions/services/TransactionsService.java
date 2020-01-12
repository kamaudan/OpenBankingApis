package com.openbanking.transactions.services;

import com.openbanking.transactions.models.Transaction;
import com.openbanking.transactions.models.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionsService {
    List<Transaction> queryTransactions();

    List<Transaction> queryTransactionsByType(TransactionType transactionType);

    BigDecimal queryTotalByTransactionType(TransactionType transactionType);
}
