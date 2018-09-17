package com.code.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class ConsumerController {

    @Autowired
    private FeignTest feignTest;

   /* @RequestMapping("/testConsumer")
    public String testConsumer(){

        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER/test/testServer",String.class).getBody();

    }

    @RequestMapping("/testFeign2")
    public String testFeign2(){

        return restTemplate.getForEntity("http://trade-query/statistic/investTopYesterday",String.class).getBody();

    }*/

    @RequestMapping("/testFeign")
    public String testFeign(){

        System.out.println("..............");
        return feignTest.testFe();

    }
}
