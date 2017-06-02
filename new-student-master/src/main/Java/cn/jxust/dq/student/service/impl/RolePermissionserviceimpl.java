package cn.jxust.dq.student.service.impl;

import cn.jxust.dq.student.dao.RolePermissionMapper;
import cn.jxust.dq.student.entity.RolePermission;
import cn.jxust.dq.student.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
@Service
public class RolePermissionserviceimpl implements RolePermissionService{
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Override
    public List<RolePermission> selectByPrimaryKey(int id) {
        return (List<RolePermission>) rolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKey(int id) {
        rolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(RolePermission rolePermission) {
        rolePermissionMapper.insert(rolePermission);
    }

    @Override
    public void updateByPrimaryKey(RolePermission rolePermission) {
        rolePermissionMapper.updateByPrimaryKey(rolePermission);
    }
}
