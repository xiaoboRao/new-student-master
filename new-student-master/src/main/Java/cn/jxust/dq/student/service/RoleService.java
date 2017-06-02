package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Role;
import cn.jxust.dq.student.entity.RoleExample;
import cn.jxust.dq.student.entity.User;
import cn.jxust.dq.student.entity.UserRole;

import java.util.List;

/**
 * Created by xixi on 2017/5/12.
 */
public interface RoleService {
     List<Role> selectByPrimaryKey(int id);
     void deleteByPrimaryKey(int id);
     void insert(Role role);
     void updateByPrimaryKey(Role role);
     List<Role> findAll(RoleExample roleExample);
     Role findByname(String name);



}
