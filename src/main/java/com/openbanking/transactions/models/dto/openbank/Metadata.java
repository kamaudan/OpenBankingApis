package com.openbanking.transactions.models.dto.openbank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Metadata {
    @JsonProperty("image_URL")
    private String imageURL;
}