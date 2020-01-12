package com.openbanking.transactions.models.dto.openbank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractOpenBankAccount {
    private String id;
    private String number;
}
