package com.vbn.platform.entitys;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by vbn on 2018/12/25.
 */
public class BaseEntity implements Serializable{

    @JSONField(name = "Id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
