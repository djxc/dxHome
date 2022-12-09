package com.djxc.study.web.config;//package com.djxc.demo.config;
//
//import com.djxc.demo.annotation.AnonymousAccess;
//import com.djxc.demo.service.impl.UserDetailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
///**
// * 权限认证管理
// * @FileDescription 权限认证管理
// * 1、系统的配置，采用springboot security进行权限认证
// * 2、设置了匿名请求
// * @Author small dj
// * @Date 2020-11-02
// * @LastFileEdtor small dj
// * @LastEditorTime 2020-11-02
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfiguration {
//    @Autowired
//    private UserDetailServiceImpl userDetailServiceImpl;
//    private final ApplicationContext applicationContext;
//    private Set<String> anonymousUrls = new HashSet<>();
//
//
//    public WebSecurity(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//        // 搜寻匿名标记 url： @AnonymousAccess
//        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = applicationContext.
//                getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
//        for (Map.Entry<RequestMappingInfo, HandlerMethod> infoEntry : handlerMethodMap.entrySet()) {
//            HandlerMethod handlerMethod = infoEntry.getValue();
//            AnonymousAccess anonymousAccess = handlerMethod.getMethodAnnotation(AnonymousAccess.class);
//            if (null != anonymousAccess) {
//                anonymousUrls.addAll(infoEntry.getKey().getPatternsCondition().getPatterns());
//            }
//        }
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
////
////        // csrf关闭，post请求可以访问，不然post
////        http
////                .cors().disable()
////                .csrf().disable()
////                .authorizeRequests()
////                // 自定义匿名访问所有url放行 ： 允许匿名和带权限以及登录用户访问
////                .antMatchers(anonymousUrls.toArray(new String[0])).permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
////                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userDetailServiceImpl))
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//}
