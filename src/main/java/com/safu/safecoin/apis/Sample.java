package com.safu.safecoin.apis;

@RestController
public class Sample {

    @Autowired
    private SaleService saleService;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public Map<String, Object> getUserById(@PathVariable("userId") long userId) {
    }
}