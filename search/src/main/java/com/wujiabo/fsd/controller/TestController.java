package com.wujiabo.fsd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    String port;

    @GetMapping("/")
    public String home() {
        return "Hello world ,port:" + port;
    }

    @GetMapping("/testSearch")
    public String testSearch(@RequestHeader(value="Authorization") String token){
        System.out.println(token);
        return "testSearch";
    }
}
