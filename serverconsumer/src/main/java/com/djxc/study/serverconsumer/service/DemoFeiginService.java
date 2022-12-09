package com.djxc.study.serverconsumer.service;

import com.djxc.study.serverapi.FeignApi.DemoFeignFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoFeiginService {

    @Autowired(required = false)
    private DemoFeignFacade demoFeignFacade;

    public String callMethod() {
        return demoFeignFacade.callConsulProvider();
    }
}
