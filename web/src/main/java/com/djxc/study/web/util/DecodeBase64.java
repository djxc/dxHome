package com.djxc.study.web.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DecodeBase64 {
    public static boolean decode(String content) {
        try {
            String str = new String(content.getBytes(StandardCharsets.UTF_8), "GB2312");
            byte[] decodeBytes = Base64.getDecoder().decode(content);
            System.out.println(new String(decodeBytes));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = new String("7B5B595819B0160c020b0c04008f012223C00353150056D01201155681FF2ad1ac05c878030d4028a007072ad1ac05c4900493e028a007072ad1ac05bcc007a12028a007062ad1ac05b1080c350028a007042ad1ac05a168124f8028a007022ad1ac058de019f0a028a007002ad1ac05767023186028a006fd2ad1ac055b182dc6c028a006f92ad1ac053bd839fbc028a006f5368ec805a55010c8e00c1c0703368ec805a168124f800c1c0702368ec8059998155cc00c1c0701368ec8058de019f0a00c1c0700368ec8057e40200b200c1c06fd368ec8056ab827ac400c1c06fb368ec805534830d4000c1c06f8368ec80537f03b82600c1c06f4368ec80518b047b7600c1c06f12f4d4f0582281e84802a9406fe2f4d4f057e40200b202a9406fd2f4d4f0576702318602a9406fd2f4d4f056ab827ac402a9406fb2f4d4f055b182dc6c02a9406f92f4d4f0547903567e02a9406f62f4d4f0530203e8fa02a9406f4002af500c7034a705D7D");
        // 编码
        String encodedStr = Base64.getEncoder().encodeToString(s.getBytes("GB2312"));
        System.out.println("长度：" + encodedStr.length() + " 编码后：" + encodedStr);

        // 解码
        byte[] decodeBytes = Base64.getDecoder().decode("N0I1QjU5NTgxOUIwMTYwYzAyMGIwYzA0MDA4ZjAxMjIyM0MwMDM1MzE1MDA1NkQwMTIwMTE1NTY4MUZGMmFkMWFjMDVjODc4MDMwZDQwMjhhMDA3MDcyYWQxYWMwNWM0OTAwNDkzZTAyOGEwMDcwNzJhZDFhYzA1YmNjMDA3YTEyMDI4YTAwNzA2MmFkMWFjMDViMTA4MGMzNTAwMjhhMDA3MDQyYWQxYWMwNWExNjgxMjRmODAyOGEwMDcwMjJhZDFhYzA1OGRlMDE5ZjBhMDI4YTAwNzAwMmFkMWFjMDU3NjcwMjMxODYwMjhhMDA2ZmQyYWQxYWMwNTViMTgyZGM2YzAyOGEwMDZmOTJhZDFhYzA1M2JkODM5ZmJjMDI4YTAwNmY1MzY4ZWM4MDVhNTUwMTBjOGUwMGMxYzA3MDMzNjhlYzgwNWExNjgxMjRmODAwYzFjMDcwMjM2OGVjODA1OTk5ODE1NWNjMDBjMWMwNzAxMzY4ZWM4MDU4ZGUwMTlmMGEwMGMxYzA3MDAzNjhlYzgwNTdlNDAyMDBiMjAwYzFjMDZmZDM2OGVjODA1NmFiODI3YWM0MDBjMWMwNmZiMzY4ZWM4MDU1MzQ4MzBkNDAwMGMxYzA2ZjgzNjhlYzgwNTM3ZjAzYjgyNjAwYzFjMDZmNDM2OGVjODA1MThiMDQ3Yjc2MDBjMWMwNmYxMmY0ZDRmMDU4MjI4MWU4NDgwMmE5NDA2ZmUyZjRkNGYwNTdlNDAyMDBiMjAyYTk0MDZmZDJmNGQ0ZjA1NzY3MDIzMTg2MDJhOTQwNmZkMmY0ZDRmMDU2YWI4MjdhYzQwMmE5NDA2ZmIyZjRkNGYwNTViMTgyZGM2YzAyYTk0MDZmOTJmNGQ0ZjA1NDc5MDM1NjdlMDJhOTQwNmY2MmY0ZDRmMDUzMDIwM2U4ZmEwMmE5NDA2ZjQwMDJhZjUwMGM3MDM0YTcwNUQ3RA");
        String decodedStr = new String(decodeBytes, "GB2312");
        System.out.println("长度：" + decodedStr.length() + " 解码后：" + decodedStr);
        System.out.println("杜杰");

    }
//    public static void main(String[] args) {
//        decode("PhMtA4ZiRUhc+i4Sk8RokAEx");
//    }
}
