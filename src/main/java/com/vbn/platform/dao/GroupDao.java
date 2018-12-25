package com.vbn.platform.dao;

import com.vbn.platform.entitys.Group;
import com.vbn.platform.entitys.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by vbn on 2018/12/25.
 */
@Repository
public interface GroupDao extends tk.mybatis.mapper.common.Mapper<Group> {


}