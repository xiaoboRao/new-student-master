package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.User;

/**
 * Created by xixi on 2017/5/12.
 */
public interface IUserService {
     User getUserById(int userId);

     User getUserByUsername(String username);

     void insertUser(User user);


}
