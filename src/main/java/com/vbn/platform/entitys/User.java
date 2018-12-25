package com.vbn.platform.entitys;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vbn on 2018/12/18.
 */

@Table(name = "tb_member")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(generator = "JDBC")
    @JSONField(name = "Id")
    private String id;

    private String phone;

    private String passwd;

    private String token;

    @Transient
    private List<Group>groupList;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    static public User createTestUser() {
        User u = new User();
        u.setId("1");
        u.setPhone("13372788028");
        u.setPasswd("123456");
        return u;
    }

    public void deletePwd() {
        this.setPasswd("");
    }


}

