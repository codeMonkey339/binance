package com.safu.safecoin.controller.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddrQueryResponse {
    String addr;
    String info;
    Double score;
    String scamType;
}
