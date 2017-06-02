package cn.jxust.dq.student.service.impl;

import cn.jxust.dq.student.dao.UserRoleMapper;
import cn.jxust.dq.student.entity.UserRole;
import cn.jxust.dq.student.service.UserRoleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
@Service


public class UserRoleserviceimpl implements UserRoleservice {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public List<UserRole> selectByPrimaryKey(int id) {

        return (List<UserRole>) userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKey(int id) {
        userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(UserRole userRole) {
        userRoleMapper.insert(userRole);
    }

    @Override
    public void updateByPrimaryKey(UserRole userRole) {
    userRoleMapper.insert(userRole);
    }
}
