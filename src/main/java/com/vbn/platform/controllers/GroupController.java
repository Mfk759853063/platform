package com.vbn.platform.controllers;

import com.alibaba.fastjson.JSONObject;
import com.vbn.platform.entitys.Group;
import com.vbn.platform.entitys.JSONResult;
import com.vbn.platform.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vbn on 2018/12/25.
 */

@Api(description = "群组相关API")
@RestController
@RequestMapping(value = "/group", produces = "application/json;charset=UTF-8")
public class GroupController {

    @Autowired
    GroupService groupService;

    @ApiOperation(value = "获取所有群组")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    private JSONObject all() {
        List<Group> list = groupService.findAllGroup();
        return JSONResult.fillResultString(0, "获取成功", list);
    }

}
