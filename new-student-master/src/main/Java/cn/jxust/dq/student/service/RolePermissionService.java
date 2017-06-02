package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Role;
import cn.jxust.dq.student.entity.RolePermission;

import java.util.List;

/**
 * Created by xixi on 2017/5/12.
 */
public interface RolePermissionService {
     List<RolePermission> selectByPrimaryKey(int id);
     void deleteByPrimaryKey(int id);
     void insert(RolePermission rolePermission);
     void updateByPrimaryKey(RolePermission rolePermission);

}
