package com.code.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/testConsumer")
    public String testConsumer(){

        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER/test/testServer",String.class).getBody();

    }
}
