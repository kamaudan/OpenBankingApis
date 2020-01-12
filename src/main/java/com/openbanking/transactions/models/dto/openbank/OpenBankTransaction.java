package com.openbanking.transactions.models.dto.openbank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
 *   "id": "String",
 *   "this_account": {
 *     "id": "String"
 *   },
 *   "other_account": {
 *     "id": "5995d6a2-01b3-423c-a173-5481df49bdaf",
 *     "holder": {
 *       "name": "OBP"
 *     },
 *     "metadata": {
 *       "image_URL": "www.openbankproject.com"
 *     }
 *   },
 *   "details": {
 *     "type": "AC",
 *     "description": "this is for family",
 *     "value": {
 *       "currency": "EUR",
 *       "amount": "10"
 *     }
 *   }
 * }
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankTransaction {
    private String id;

    @JsonProperty("this_account")
    private OpenBankAccount thisAccount;

    @JsonProperty("other_account")
    private CounterPartyOpenBankAccount otherAccount;

    private TransactionDetails details;
}