package com.djxc.study.serverconsumer.controller;

import com.djxc.study.serverconsumer.service.DemoFeiginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testFeign")
public class FeiginConsumerController {

    @Autowired
    private DemoFeiginService demoFeiginService;


    @GetMapping("/demo")
    public String demo() {
        return demoFeiginService.callMethod();
    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }
}
