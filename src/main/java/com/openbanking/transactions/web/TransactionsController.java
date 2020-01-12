package com.openbanking.transactions.web;

import com.openbanking.transactions.models.Transaction;
import com.openbanking.transactions.models.TransactionType;
import com.openbanking.transactions.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    private final TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> getTransactions() {
        return transactionsService.queryTransactions();
    }

    @GetMapping(value = "/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> getTransactionByType(@PathVariable TransactionType type) {
        return transactionsService.queryTransactionsByType(type);
    }

    @GetMapping(value = "/{type}/amount", produces = MediaType.APPLICATION_JSON_VALUE )
    public BigDecimal getTotalAmount(@PathVariable TransactionType type) {
        return transactionsService.queryTotalByTransactionType(type);
    }
}
