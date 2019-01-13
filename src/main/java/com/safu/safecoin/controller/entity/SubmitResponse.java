package com.safu.safecoin.controller.entity;

import lombok.*;

@Data
@Builder
public class SubmitResponse {
   String responseInfo;
   int submitOrder;
}
