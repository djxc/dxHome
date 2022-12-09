package com.djxc.study.serverapi.FeignApi;

import com.djxc.study.serverapi.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "dj-demo", url="http://localhost:8083/producer1", configuration = FeignConfig.class)
public interface DemoFeignFacade {
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    List<User> queryAllUser();

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    String callConsulProvider();
}
