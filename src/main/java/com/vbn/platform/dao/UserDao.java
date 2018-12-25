package com.vbn.platform.dao;

import com.vbn.platform.entitys.Group;
import com.vbn.platform.entitys.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vbn on 2018/12/25.
 */
@Repository
public interface UserDao extends tk.mybatis.mapper.common.Mapper<User> {

    List<Group> selectGroupsByUser(User u);

}
