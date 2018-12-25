package com.vbn.platform.controllers;

import com.alibaba.fastjson.JSONObject;
import com.vbn.platform.annotations.UserLoginToken;
import com.vbn.platform.entitys.Group;
import com.vbn.platform.entitys.JSONResult;
import com.vbn.platform.entitys.User;
import com.vbn.platform.service.UserService;
import com.vbn.platform.utils.TokenService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vbn on 2018/12/18.
 */

@Api(description = "用户相关API")
@RestController
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class UserController extends BaseController{

    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;


    @ApiOperation(value = "用户登录")
    @RequestMapping(value="/login", method=RequestMethod.POST)
    private JSONObject login(@RequestParam(value = "phone") String phone,
                             @RequestParam(value = "pwd") String pwd) {
        User u = userService.verifyUser(phone, pwd);
        if (u != null) {
            u.setToken(tokenService.getToken(u));
            userService.updateUserToken(u);
            List<Group> groupList = userService.findGroupsByUser(u);
            u.setGroupList(groupList);
            u.deletePwd();
            return JSONResult.fillResultString(1, "登錄成功", u);
        } else {
            return JSONResult.fillResultString(-1, "登錄失敗", "");
        }
    }

    @ApiOperation(value = "测试api,需要token认证")
    @UserLoginToken
    @RequestMapping(value="/message", method = RequestMethod.GET)
    private String message() {
        return "ok";
    }
}
