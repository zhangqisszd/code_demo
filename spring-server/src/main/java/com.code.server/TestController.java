package com.code.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("testServer")
    public String testServer(){

        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        List<String> list = discoveryClient.getServices();

        log.info(list.toString());
        log.info("host {}  serviceId {}",instance.getHost(),instance.getServiceId());
        return "xxxxxxxxxxxxxxx";
    }
}
