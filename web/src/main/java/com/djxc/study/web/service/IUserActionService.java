package com.djxc.study.web.service;

import com.djxc.study.demo.entity.UserAction;

import java.util.List;

public interface IUserActionService {

    List<UserAction> getUserAction();
    // 获取所有的用户操作记录，分页显示
    List<UserAction> getUserAction(int page, int pageNum);
    // 增加一条用户操作记录
    boolean addUserAction(UserAction userAction);
}
