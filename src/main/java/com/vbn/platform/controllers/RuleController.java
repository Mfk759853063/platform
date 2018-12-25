package com.vbn.platform.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vbn on 2018/12/18.
 */

@Api(description = "权限相关API")
@RestController
@RequestMapping(value = "/rule", produces = "application/json;charset=UTF-8")
public class RuleController extends BaseController{


    @ApiOperation(value = "添加权限")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private  String addRule() {
        return "hello world";
    }
}
