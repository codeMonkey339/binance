package com.safu.safecoin.service.external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry{
    private long id;
    private String name;
    private String url;
    private String coin;
    private String category; // like phishing
    private String subCategory; // like Gatcoin
    private String description;
    private List<String> addresses; // wallet addresses
    private String reporter; // user name
    private String status; //online, offline
}