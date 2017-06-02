package cn.jxust.dq.student.service.impl;

import cn.jxust.dq.student.dao.RoleMapper;
import cn.jxust.dq.student.dao.UserMapper;
import cn.jxust.dq.student.entity.*;
import cn.jxust.dq.student.service.IUserService;
import cn.jxust.dq.student.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xixi on 2017/5/12.
 */
@Service
public class RoleServiceImpl implements RoleService {
    /**
     *
     */
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> selectByPrimaryKey(int id) {
        return (List<Role>) roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKey(int id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updateByPrimaryKey(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public List<Role> findAll(RoleExample roleExample) {
        RoleExample roleExample1=new RoleExample();
        return roleMapper.selectByExample(roleExample1);
    }

    @Override
    public Role findByname(String name) {
        RoleExample roleExample=new RoleExample();
        List<Role> roles = this.findAll(roleExample);
        for (Role role:roles
             ) {
            if(role.getName().equals(name))
            {
                System.out.println("role.getName() = " + role.getName());
                return role;
            }
        }
        return null;
    }


}