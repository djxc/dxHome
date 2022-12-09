package com.djxc.study.web.entity;

import java.util.Date;

/**
 * 用户行为记录
 * 1、记录用户的登录、查询以及请求api事件等信息。
 */
public class UserAction {
    private String username;
    private String userRole;
    private String action_type;
    private Date action_time;
    private String bowser_type;
    private String use_time;
    private String action_result;

    public UserAction(){}

    public UserAction(String username,
                      String action_type, Date action_time,
                      String bowser_type, String use_time,
                      String action_result) {
        this.username = username;
        this.action_type = action_type;
        this.action_time = action_time;
        this.bowser_type = bowser_type;
        this.use_time = use_time;
        this.action_result = action_result;
    }

    public UserAction(String username, String userRole,
                      String action_type, Date action_time,
                      String bowser_type, String use_time,
                      String action_result) {
        this.username = username;
        this.userRole = userRole;
        this.action_type = action_type;
        this.action_time = action_time;
        this.bowser_type = bowser_type;
        this.use_time = use_time;
        this.action_result = action_result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public Date getAction_time() {
        return action_time;
    }

    public void setAction_time(Date action_time) {
        this.action_time = action_time;
    }

    public String getBowser_type() {
        return bowser_type;
    }

    public void setBowser_type(String bowser_type) {
        this.bowser_type = bowser_type;
    }

    public String getUse_time() {
        return use_time;
    }

    public void setUse_time(String use_time) {
        this.use_time = use_time;
    }

    public String getAction_result() {
        return action_result;
    }

    public void setAction_result(String action_result) {
        this.action_result = action_result;
    }
}
