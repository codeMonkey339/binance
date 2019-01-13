package com.safu.safecoin.controller.entity;

import lombok.*;

@Data
@Builder
public class SubmitResponse {
    public SubmitResponse(String res){
        this.responseInfo = res;
    }
    String responseInfo;
}
