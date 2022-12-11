package com.djxc.study.serverproducer.impl;


import com.djxc.study.serverapi.FeignApi.DemoFeignFacade;
import com.djxc.study.serverapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoFeignFacedeImpl implements DemoFeignFacade {
    @Override
    public List<User> queryAllUser() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        userList.add(user);
        return userList;
    }

    @Override
    public String callConsulProvider() {
        System.out.println("this is producer!");
        return "djxc";
    }
}
