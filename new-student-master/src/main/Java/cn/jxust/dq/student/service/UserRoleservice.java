package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.UserRole;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface UserRoleservice {


    List<UserRole> selectByPrimaryKey(int id);
    void deleteByPrimaryKey(int id);
    void insert(UserRole userRole);
    void updateByPrimaryKey(UserRole userRole);
}
