package com.vbn.platform.entitys;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vbn on 2018/12/25.
 */

@Table(name = "tb_group")
public class Group extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
