package com.safu.safecoin.service;

import com.safu.safecoin.controller.entity.AddrQueryResponse;
import com.safu.safecoin.service.external.EtherscamdbService;
import com.safu.safecoin.service.external.entity.Entry;
import com.safu.safecoin.service.external.entity.EtherQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddrService {

    @Autowired
    private EtherscamdbService etherscamdbService;

    public AddrQueryResponse getQueryResult(String addr){
        EtherQueryResponse res = etherscamdbService.queryAddr(addr);

        AddrQueryResponse.AddrQueryResponseBuilder builder = AddrQueryResponse
                .builder()
                .addr(addr);
        if (res.isSuccess()){
            Entry entry = res.getEntries().get(0);
            return builder
                    .info(entry.getDescription())
                    .scamType(entry.getCategory())
                    .score(100.0) // TODO: just placeholder
                    .build();

        }else{
            return builder
                    .score(0.0)
                    .build();
        }
    }
}
