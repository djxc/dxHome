package com.djxc.study.web.entity;

/**
 * @FileDescription 请求返回对象，统一请求返回的格式
 * 1、status：描述的是请求处理的状态码；
 * 2、msg：描述返回说明
 * @Author small dj
 * @Date 2020-11-02
 * @LastEditor 2020-11-02
 * @LastEditTime 2020-11-02
 */
public class ResponseEntity {
    private int status;     // 返回的状态码
    private String msg;     // 返回的说明信息
    private Object data;    // 返回的数据

    public ResponseEntity() {}

    public ResponseEntity(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
