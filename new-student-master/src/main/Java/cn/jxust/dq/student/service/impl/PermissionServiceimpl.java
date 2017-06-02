package cn.jxust.dq.student.service.impl;

import cn.jxust.dq.student.dao.PermissionMapper;
import cn.jxust.dq.student.entity.Permission;
import cn.jxust.dq.student.entity.PermissionExample;
import cn.jxust.dq.student.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Permissions;
import java.util.List;

/**
 * Created by xixi on 2017/5/12.
 */
@Service
public class  PermissionServiceimpl implements PermissionService{

     @Autowired
     private PermissionMapper permissionMapper;
     @Override
     public List<Permission> selectByPrimaryKey(int id) {
          return (List<Permission>) permissionMapper.selectByPrimaryKey(id);
     }

     @Override
     public void deleteByPrimaryKey(int id) {
          permissionMapper.deleteByPrimaryKey(id);
     }

     @Override
     public void insert(Permission permission) {
     permissionMapper.insert(permission);
     }

     @Override
     public void updateByPrimaryKey(Permission permission) {
          permissionMapper.updateByPrimaryKey(permission);
     }

     @Override
     public List<Permission> findall(PermissionExample permissionExample) {
          return permissionMapper.selectByExample(permissionExample);
     }

     @Override
     public Permission findpermissionbyname(String name) {
          PermissionExample permissionExample=new PermissionExample();
          List<Permission> permissions=this.findall(permissionExample);
          for (Permission permission: permissions
               ) {
               if(permission.getName().equals(name))
               {
                    return  permission;
               }
          }
          return null;
     }
}
