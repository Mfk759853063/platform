package com.vbn.platform.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vbn.platform.entitys.User;
import org.springframework.stereotype.Service;

/**
 * Created by vbn on 2018/12/18.
 */

@Service("tokenService")
public class TokenService {

    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPasswd()));
        return token;
    }
}
