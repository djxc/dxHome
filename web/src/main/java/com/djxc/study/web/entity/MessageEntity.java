package com.djxc.study.web.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageEntity {
    private Date receiveTime;
    private String dataPayload;
    private String msisdn;
    private int dataLen;
    private int serverId;
}
