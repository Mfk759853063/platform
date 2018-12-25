package com.vbn.platform.service;

import com.vbn.platform.dao.UserDao;
import com.vbn.platform.entitys.Group;
import com.vbn.platform.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by vbn on 2018/12/25.
 */

@Service("userService")
public class UserService {

    @Autowired
    UserDao userDao;

    public int addUser(User user) {
        return userDao.insertSelective(user);
    }

    public User findUserById(String id) {
        User u = new User();
        u.setId(id);
        return userDao.selectOne(u);
    }

    public User verifyUser(String phone, String pwd) {
        Example example = new Example(User.class);
        Example.Criteria cirteria = example.createCriteria();
        cirteria.andEqualTo("phone", phone);
        cirteria.andEqualTo("passwd", pwd);
        List<User> list = userDao.selectByExample(example);
        return list.iterator().next();
    }

    public void updateUserToken(User u) {
        userDao.updateByPrimaryKey(u);
    }

    public List<Group> findGroupsByUser(User u) {
        return userDao.selectGroupsByUser(u);
    }
}
