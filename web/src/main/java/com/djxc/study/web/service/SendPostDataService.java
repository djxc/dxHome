package com.djxc.study.web.service;

import com.alibaba.fastjson2.JSONObject;
import com.djxc.study.web.entity.DataEntity;
import com.djxc.study.web.entity.MessageEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SendPostDataService {
    public boolean sendData(MessageEntity msg) {
        String url = "http://115.28.236.114/OceanObserveForTT/receivedata/newData";
        WebClient webClient = WebClient.builder()
                .baseUrl(url).build();
        String msgStr = JSONObject.toJSONString(msg);
        DataEntity data = new DataEntity();
        data.setData(msgStr);
        String dataStr = JSONObject.toJSONString(data);
        System.out.println(dataStr);
        Mono<String> mono = webClient.post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(data))
                .retrieve()
                .bodyToMono(String.class);
        System.out.println(mono.block());
//        mono.subscribe(result -> {
//            System.out.println(result);
//        });
        return true;
    }

    public static void main(String[] args) {
        String content = "7B5B595819B0160c020b0c04008f012223C00353150056D01201155681FF2ad1ac05c878030d4028a007072ad1ac05c4900493e028a007072ad1ac05bcc007a12028a007062ad1ac05b1080c350028a007042ad1ac05a168124f8028a007022ad1ac058de019f0a028a007002ad1ac05767023186028a006fd2ad1ac055b182dc6c028a006f92ad1ac053bd839fbc028a006f5368ec805a55010c8e00c1c0703368ec805a168124f800c1c0702368ec8059998155cc00c1c0701368ec8058de019f0a00c1c0700368ec8057e40200b200c1c06fd368ec8056ab827ac400c1c06fb368ec805534830d4000c1c06f8368ec80537f03b82600c1c06f4368ec80518b047b7600c1c06f12f4d4f0582281e84802a9406fe2f4d4f057e40200b202a9406fd2f4d4f0576702318602a9406fd2f4d4f056ab827ac402a9406fb2f4d4f055b182dc6c02a9406f92f4d4f0547903567e02a9406f62f4d4f0530203e8fa02a9406f4002af500c7034a705D7D";
//        try {
//            content = Base64.getEncoder().encodeToString(content.getBytes("GB2312"));
//            MessageEntity messageEntity = new MessageEntity();
//            messageEntity.setReceiveTime(new Date());
//            messageEntity.setDataPayload(content);
//            messageEntity.setMsisdn("17400189044");
//            messageEntity.setDataLen(18);
//            SendPostDataService sendPostDataService = new SendPostDataService();
//            sendPostDataService.sendData(messageEntity);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        System.out.println("汉字");

    }
}
