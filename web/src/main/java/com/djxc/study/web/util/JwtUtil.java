package com.djxc.study.web.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

/**
 * token秘钥的工具
 * @FileDescription token秘钥相关工具
 * 1、秘钥的生成，设置过期时间，根据用户名以及密码生成秘钥
 * 2、token的验证
 * 3、解析token获取其中的用户信息
 * @Author small dj
 * @Date 2020-11-02
 * @LastFileEditor small dj
 * @LastFileTime 2020-11-02
 */
public class JwtUtil {
    private final static long EXPIRE_TIME = 5* 60*1000;
    // token私钥
    private static final String TOKEN_SECRET = "djxcbeihang1025aishihengjiurennai";


    public static void main(String[] args) {
        String token = sign("dj", "123");
        System.out.println(token);
    }

    /**
     * 生成签名，5分钟后过期
     * 1、计算过期的时间
     * 2、通过token私钥定义算法
     * 3、生成加密的token字符串并返回
     * @param username 用户名称
     * @param secret 用户密码
     * @return 加密的token
     */
    public static String sign (String username, String secret) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 验证token是否正确
     * @param token 秘钥
     * @param username 用户名
     * @param secret 用户密码
     * @return 是否正确
     */
    public static boolean verity(String token, String username, String secret) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取token中的信息，
     * @param token
     * @return token中的用户名
     */
    public static String getUsername(String token) {
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }

    /**
     * 生成加密的token
     * 需要传入用户名以及密码参数
     * 1、计算过期的时间
     * 2、通过token私钥定义算法
     * 3、生成加密的token字符串并返回
     * @param userName 用户名
     * @param userID 密码
     * @return String 加密的token字符串
     */
    public static String createToken(String userName, String userID) {
        Date data = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        String token = JWT.create().
                withHeader(header).withClaim("username", userName)
                .withClaim("userID", userID).withExpiresAt(data).sign(algorithm);
        System.out.println(token);
        return token;
    }

    /**
     * 验证传递过来的token是否正取
     * 1、通过秘钥生成算法
     * 2、根据算法生成验证对象
     * 3、如果验证通过则返回true
     * @param token 加密的token
     * @return boolean 是否正确
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier =JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(jwt);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }catch (JWTVerificationException e){
            return false;
        }
    }

}
