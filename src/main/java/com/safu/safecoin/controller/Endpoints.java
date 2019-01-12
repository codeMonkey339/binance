package com.safu.safecoin.controller;

import com.safu.safecoin.controller.entity.AddrQueryResponse;
import com.safu.safecoin.controller.entity.Alert;
import com.safu.safecoin.controller.entity.MoneyOriginQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import java.util.Date;
import java.util.List;

@RestController
public class Endpoints {

//    @Autowired
//    private SaleService saleService;
//
//    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
//    public Map<String, Object> getUserById(@PathVariable("userId") long userId) {
//    }

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
    public String submitAddr(String userId, String addr, String proof, String
            trans, MultipartFile img, int scamType){
        //TODO: persist the potential address in db
        return null;
    }

    /**
     *
     * @param addr
     * @param queryType whether the query is 2C or 2B
     * @param userId
     * @return
     */
    @RequestMapping(value="/addr/query", method= RequestMethod.GET)
    public AddrQueryResponse queryAddr(String addr, int queryType, String
            userId){
        //TODO:
        return null;
    }

    /**
     * check whether the addr is a money laundering address, if yes, return
     * the recent transaction histories
     * @param addr
     * @param userId
     * @return
     */
    @RequestMapping(value="/aml/query", method=RequestMethod.GET)
    public MoneyOriginQueryResponse queryMoneyOrign(String addr, String userId){
        //TODO:
        return null;
    }

    /**
     * get the latest num of alerts
     * @param num
     * @return
     */
    @RequestMapping(value="/alert/query", method=RequestMethod.GET)
    public List<Alert> getLatestAlert(int num){
        //TODO
        return null;
    }

    @RequestMapping(value="/submit/num/query/date", method=RequestMethod.GET)
    public int getSubmissionNumByDate(Date date){
        //TODO
        return -1;
    }

    @RequestMapping(value="/submit/num/query/range", method=RequestMethod.GET)
    public List<Integer> getSubmissionNum30Days(Date date){
        //TODO
        return null;
    }
}