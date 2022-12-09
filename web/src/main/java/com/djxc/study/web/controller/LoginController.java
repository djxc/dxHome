package com.djxc.study.web.controller;

import com.djxc.study.demo.annotation.AnonymousAccess;
import com.djxc.study.demo.entity.User;
import com.djxc.study.demo.service.IUserService;
import com.djxc.study.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录
 * @FileDescription 用户登录控制器
 * 1、用户服务的注入，根据用户服务进行查询等操作
 * @Author small dj
 * @Date 2020-11-02
 * @LastFileEdit 2020-11-02
 * @LastFileEditor small dj
 */

@RestController
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 如果请求不需要进行权限认证，则添加AnonymousAccess注释
     * @return
     */
    @AnonymousAccess
    @RequestMapping(value = "/")
    public String index() {
        return "hello world";
    }

    /**
     * 查询数据
     * @return
     */
    @RequestMapping(value = "/select")
    public String login(){
        User users = userService.selectById(1);
        String result =  users.getName() + " --> " + users.getPasswd() + " --> " + users.getAuthority();
        return result;
    }

    /**
     * **用户登录**
     * 1、通过post请求将用户信息传给服务器，服务器将其参数生成为一个bean对象
     * 2、根据当前用户的名称查询用户密码，如果存在该用户则可以查询到密码，如果不存在该用户则查询不到密码登录失败，
     * 返回状态为200， info为“not found this user”
     * 3、如果存在需要进一步判断密码与登录输入的密码是否一致，
     * 如果一致则登录成功，返回状态设为200，info为用户的信息；
     * 如果不一致，则登录失败，返回状态200，info为"invalid name or password"
     * 4、如果登录成功需要生成一个token返回给客户端，客户之后的每个请求都需要携带token，
     * 服务器端需要验证token正确性，然后才处理请求。
     * 5、登录成功后需要将当前用户登录信息：浏览器、ip、时间写到登录事件的表中
     * @param user
     * @return authority 返回用户的权限
     */
    @AnonymousAccess
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> authLogin(@RequestBody User user) {
        String name = user.getName();
        String passwd = user.getPasswd();
        System.out.println(name + " -> " + passwd);
        User user_find = userService.selectByName(name);
        Map<String, Object> response = new HashMap<>();
        if(user_find != null) {
            if(passwd.equals(user_find.getPasswd())) {
                String token = JwtUtil.sign(name, passwd);
                response.put("status", "ok");
                response.put("info", user_find);
                response.put("token", token);
                System.out.println("success");
                return new ResponseEntity<Object>(response, HttpStatus.OK);
            }else{
                response.put("status", "error");
                response.put("info", "invalid name or password");
                System.out.println("success");
                return new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
            }
        }else{
            response.put("status", "error");
            response.put("info", "not found this user");
            System.out.println("success");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
