package com.safu.safecoin.controller.entity;

import lombok.Data;

import java.util.List;

@Data
public class MoneyOriginQueryResponse {
    List<List<String>> transactionHistories; // empty if not money laundering
    Boolean isMoneyLanunder;
}
