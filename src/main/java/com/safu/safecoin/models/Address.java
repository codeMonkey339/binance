package com.safu.safecoin.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Addr {
    private String addr;
    private String proof;
    //private File image; // not implemented
    private User reporter; // the first one reported the bad address
    private Set<User> approvers; // users who concurred with the reporter
    private double score;
    private int scamType;
}
