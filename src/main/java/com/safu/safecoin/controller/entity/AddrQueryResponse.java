package com.safu.safecoin.controller.entity;


import lombok.Data;

@Data
public class AddrQueryResponse {
    String addr;
    String info;
    Double score;
    int scamType;
}
