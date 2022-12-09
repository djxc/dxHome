package com.djxc.study.web.service.impl;

import com.djxc.study.demo.entity.UserAction;
import com.djxc.study.demo.service.IUserActionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现用户操作记录服务的接口
 * 1、获取用户操作记录
 * 2、添加用户操作记录
 */
@Service
public class UserActionServiceImpl implements IUserActionService {
    @Override
    public List<UserAction> getUserAction() {
        return null;
    }

    @Override
    public List<UserAction> getUserAction(int page, int pageNum) {
        return null;
    }

    @Override
    public boolean addUserAction(UserAction userAction) {
        return false;
    }

//    @Autowired
//    private UserActionMapper userActionMapper;

//    @Override
//    public List<UserAction> getUserAction() {
//        List<UserAction> userActions = userActionMapper.selectAllActions();
//        return userActions;
//    }
//
//    @Override
//    public List<UserAction> getUserAction(int page, int pageNum) {
//        List<UserAction> userActions = userActionMapper.selectAllActions();
//        return userActions;
//    }
//
//    @Override
//    public boolean addUserAction(UserAction userAction) {
//        return false;
//    }
}
