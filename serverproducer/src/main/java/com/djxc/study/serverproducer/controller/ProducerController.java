package com.djxc.study.serverproducer.controller;

import com.djxc.study.serverproducer.impl.DemoFeignFacedeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer1")
public class ProducerController {

    @Autowired
    private DemoFeignFacedeImpl demoFeignFacede;

    @GetMapping("/demo")
    public String demo() {
        return demoFeignFacede.callConsulProvider();
    }
}
