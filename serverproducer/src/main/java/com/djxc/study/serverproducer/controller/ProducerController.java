package com.djxc.study.serverproducer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer1")
public class ProducerController {

    @GetMapping("/demo")
    public String demo() {
        return "demo producer";
    }
}
