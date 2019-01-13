package com.safu.safecoin.service;

import com.safu.safecoin.controller.entity.AlertResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AlertService {
     //TODO: need to have an alert DB and some demo data

    private List<String> levels = Arrays.asList(new String[]{
            "severe",
            "info",
            "info",
            "severe",
            "warn",
            "warn",
            "red alert",
            "red alert",
            "red alert",
    });

    private List<String> infos = Arrays.asList(new String[]{
       "Frequent transactions: over 50 transactions over 24 hours",
       "Possible fraud: reported as scam by the community",
       "Possible fraud: reported as scam by the community",
       "Possible money laundering; links to potential money laundering account",
       "Illegal transaction: possible usage in illegal business",
       "Hacked account: reported as being hacked by owner",
       "Hacked account: reported as being hacked by owner",
       "Illegal transaction: possible usage in illegal business",
       "Frequent transactions: over 50 transactions over 24 hours",
    });

    private List<String> addrs = Arrays.asList(new String[]{
       "0xDaa29859836D97C810c7F9D350D4A1B3E8CafC9a",
       "0x00e01a648ff41346cdeb873182383333d2184dd1",
            "0x858457daa7e087ad74cdeeceab8419079bc2ca03",
            "0xd0cc2b24980cbcca47ef755da88b220a82291407",
            "0x240e125c20a4cc84bd6e7f8d1fd07aff4c06d43d",
            "0x11c058c3efbf53939fb6872b09a2b5cf2410a1e2c3f3c867664e43a626d878c0",
            "0x2dfe2e0522cc1f050edcc7a05213bb55bbb36884ec9468fc39eccc013c65b5e4",
            "0x1c6e3348a7ea72ffe6a384e51bd1f36ac1bcb4264f461889a318a3bb2251bf19",
            "0xaa1886de3f70a3ef502ea1379a311c5b4e05f3fd"
    });

    public List<AlertResponse> getAlerts(int num){
        List<AlertResponse> res = new ArrayList<>();
        Collections.shuffle(levels);
        Collections.shuffle(infos);
        Collections.shuffle(addrs);
        IntStream.range(0, levels.size())
                .forEach(i -> res.add(AlertResponse
                        .builder()
                        .info(infos.get(i))
                        .level(levels.get(i))
                        .addr(addrs.get(i))
                        .build()));
        if (num <= res.size()){
            return res.subList(0, res.size());
        }else{
            List<AlertResponse> augmented = new ArrayList<>();
            int times = num / res.size() + 1;
            IntStream.range(0, times)
                    .forEach(i -> augmented.addAll(res));
            Collections.shuffle(augmented);
            return augmented.subList(0, num);
        }
    }
}
