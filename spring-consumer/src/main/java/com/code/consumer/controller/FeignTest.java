package com.code.consumer.controller;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spring-cloud-server")
public interface FeignTest {

    @RequestMapping(value = "/test/testServer")
    String testFe();
}
