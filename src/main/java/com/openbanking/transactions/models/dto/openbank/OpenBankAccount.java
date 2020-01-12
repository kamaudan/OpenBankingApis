package com.openbanking.transactions.models.dto.openbank;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OpenBankAccount extends AbstractOpenBankAccount {
    private List<Holder> holders = new ArrayList<>();
}