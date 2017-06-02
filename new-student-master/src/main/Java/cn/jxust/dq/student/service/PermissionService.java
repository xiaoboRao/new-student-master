package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Permission;
import cn.jxust.dq.student.entity.PermissionExample;


import java.util.List;

/**
 * Created by xixi on 2017/5/12.
 */
public interface PermissionService {
     List<Permission> selectByPrimaryKey(int id);
     void deleteByPrimaryKey(int id);
     void insert(Permission permission);
     void updateByPrimaryKey(Permission permission);
     List<Permission> findall(PermissionExample permissionExample);
     Permission findpermissionbyname(String name);
}
