package com.djxc.study.web.service;


import com.djxc.study.web.entity.User;

public interface AuthUserService {
    User getUserByName(String name);
}
