package com.safu.safecoin.service;

import com.safu.safecoin.controller.entity.AddrQueryResponse;
import com.safu.safecoin.models.Address;
import com.safu.safecoin.repositories.WalletRepository;
import com.safu.safecoin.service.external.EtherscamdbService;
import com.safu.safecoin.service.external.entity.Entry;
import com.safu.safecoin.service.external.entity.EtherQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AddrService {

    @Autowired
    private EtherscamdbService etherscamdbService;
    @Autowired
    private WalletRepository walletRepository;
    private Set<Address> addresses = new HashSet<>();

    private final double DENOMINATOR = 5.0;
    private final int MIN = 2;

    public AddrQueryResponse getQueryResult(String addr, String queryType){
        EtherQueryResponse etherRes = etherscamdbService.queryAddr(addr);
        List<Address> occurences = getOccurrencesFromInternal(addr);
        AddrQueryResponse.AddrQueryResponseBuilder builder = AddrQueryResponse
                .builder()
                .addr(addr);
        if (etherRes.isSuccess() && etherRes.getEntries().size() > 0){
            Entry entry = etherRes.getEntries().get(0);
            return builder
                    .info(entry.getDescription())
                    .scamType(entry.getCategory())
                    .score(Math.min(1.0, (etherRes.getEntries().size() +
                            occurences.size()) / DENOMINATOR))
                    .build();
        }else{
            if (occurences.size() == 0){
                return builder
                       .info("No prior record of the searched address")
                       .score(0.2)
                       .scamType("N.A")
                       .build();
            }else{
                return builder
                        .info(String.format("Found %d occurrences",
                                occurences.size()))
                        .score(Math.min(Math.max(0, 0.2 + (occurences.size() -
                                MIN) / DENOMINATOR), 1.0))
                        .scamType(occurences.get(0).getScamType())
                        .build();
            }
        }
    }


    public List<Address> getOccurrencesFromInternal(String addr){
        List<Address> res = new ArrayList<>();
        walletRepository.findById(addr)
                .map(i -> res.add(i));
        return res;
    }

    public String submitAddr(String userId, String addr, String proof, String
            trans, MultipartFile img, String scamType, String coinType){
        Address reported = Address
                .builder()
                .addr(addr)
                .proof(proof)
                .coin(coinType)
                .reporterId(userId)
                .approverIds(new HashSet<>())
                .build();
        //TODO: persist into DB
        addresses.add(reported);
        return "";
    }
}
