package com.safu.safecoin.service;

import com.safu.safecoin.controller.entity.AlertResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    public List<AlertResponse> getAlerts(int num){
        //TODO: need to have an alert DB and some demo data
        return null;
    }
}
