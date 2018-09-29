package com.boot;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller 默认是单例
@RestController
public class TestController {

    private int num = 0;

    @RequestMapping("/test")
    private int test(){
        return ++num;
    }
}
