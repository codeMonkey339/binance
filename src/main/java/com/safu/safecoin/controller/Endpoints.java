package com.safu.safecoin.controller;

import com.safu.safecoin.controller.entity.AddrQueryResponse;
import com.safu.safecoin.controller.entity.AlertResponse;
import com.safu.safecoin.controller.entity.MoneyOriginQueryResponse;
import com.safu.safecoin.controller.entity.SubmitResponse;
import com.safu.safecoin.service.AddrService;
import com.safu.safecoin.service.AlertService;
import com.safu.safecoin.service.SubmissionNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class Endpoints {

//    @Autowired
//    private SaleService saleService;
//
//    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
//    public Map<String, Object> getUserById(@PathVariable("userId") long userId) {
//    }

    @Autowired
    private AddrService addrService;

    @Autowired
    private AlertService alertService;

    @Autowired
    private SubmissionNumService submissionNumService;

    /**
     *
     * @param userId
     * @param addr
     * @param proof
     * @param trans
     * @param img
     * @param scamType what type of bad address
     * @return
     */
    @RequestMapping(value="/addr/submit", method= RequestMethod.POST)
    public SubmitResponse submitAddr(String userId, String addr, String proof, String
            trans, MultipartFile img, String scamType, String coinType){
        return addrService.submitAddr(userId, addr, proof, trans, img,
                scamType,
                coinType);
   }

    /**
     *
     * @param addr
     * @param queryType whether the query is 2C or 2B
     * @param userId
     * @return
     */
    @RequestMapping(value="/addr/query/{addr}/{queryType}/{userId}", method= RequestMethod.GET)
    public AddrQueryResponse queryAddr(@PathVariable String addr, @PathVariable String queryType,
                                       @PathVariable String userId){
        return addrService.getQueryResult(addr, queryType);
    }

    /**
     * check whether the addr is a money laundering address, if yes, return
     * the recent transaction histories
     * @param addr
     * @param userId
     * @return
     */
    @RequestMapping(value="/aml/query/{addr}/{userId}", method=RequestMethod.GET)
    public MoneyOriginQueryResponse queryMoneyOrign(@PathVariable String addr, @PathVariable String userId){
        //TODO: implement this if time allows, hard-code some data for demo
        return null;
    }

    /**
     * get the latest num of alerts
     * @param num
     * @return
     */
    @RequestMapping(value="/alert/query/{num}", method=RequestMethod.GET)
    public List<AlertResponse> getLatestAlert(@PathVariable int num){
        return alertService.getAlerts(num);
    }

    @RequestMapping(value="/submit/num/query/date/{date}", method=RequestMethod.GET)
    public int getSubmissionNumByDate(@PathVariable Date date){
        return submissionNumService.getNumByDate(date);
    }

    @RequestMapping(value="/submit/num/query/range/{date}", method=RequestMethod.GET)
    public List<Integer> getSubmissionNum30Days(@PathVariable Date date){
        return submissionNumService.getNumsByRange(date, 30);
    }
}