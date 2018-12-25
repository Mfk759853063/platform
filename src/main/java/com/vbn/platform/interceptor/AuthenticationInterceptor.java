package com.vbn.platform.interceptor;

import com.vbn.platform.annotations.PassToken;
import com.vbn.platform.annotations.UserLoginToken;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.vbn.platform.entitys.User;
import com.vbn.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by vbn on 2018/12/18.
 */

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.print("*******************************");
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlermethod = (HandlerMethod) handler;
        Method method = handlermethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    Exception e = new RuntimeException("无token，请重新登录");
                    response.setContentType("application/json; charset=UTF-8");
                    response.getWriter().print(GloabExceptionHandler.handleException(e));
                    return false;
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    Exception error = new RuntimeException("token 验证失败");
                    response.setContentType("application/json; charset=UTF-8");
                    response.getWriter().print(GloabExceptionHandler.handleException(error));
                    return false;
                }
                User user = userService.findUserById(userId);
                if (user == null) {
                    Exception e = new RuntimeException("用户不存在");
                    response.setContentType("application/json; charset=UTF-8");
                    response.getWriter().print(GloabExceptionHandler.handleException(e));
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPasswd())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    e.printStackTrace();
                    Exception error = new RuntimeException("token 验证失败");
                    response.setContentType("application/json; charset=UTF-8");
                    response.getWriter().print(GloabExceptionHandler.handleException(error));
                    return false;
                }
                return true;
            }
        }
        return true;

    }


}
