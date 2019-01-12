package com.safu.safecoin.service.external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtherQueryResponse {


    private boolean success;
    private String result;
    private String type;
    private List<Entry> entries;
}
