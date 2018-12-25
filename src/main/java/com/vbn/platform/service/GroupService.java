package com.vbn.platform.service;

import com.vbn.platform.dao.GroupDao;
import com.vbn.platform.entitys.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vbn on 2018/12/25.
 */
@Service("groupService")
public class GroupService {

    @Autowired
    GroupDao groupDao;

    public List<Group> findAllGroup() {
        return groupDao.selectAll();
    }
}
