package com.djxc.study.web.service.impl;


import com.djxc.study.demo.dao.DJDataBase;
import com.djxc.study.demo.entity.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DJDataBase dataBase;

    public AuthUser getUserByName(String name){
        return dataBase.getDatabase().get(name);
    }
}
