package cn.jxust.dq.student.service.impl;

import cn.jxust.dq.student.dao.UserMapper;
import cn.jxust.dq.student.entity.*;
import cn.jxust.dq.student.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xixi on 2017/5/12.
 */
@Service
public class UserServiceImpl implements IUserService {
    /**
     *
     */
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserById(int userId) {

        return this.userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        UserExample userExample=new UserExample();
        List<User> users=userMapper.selectByExample(userExample);
        for (User user:users
             ) {
            if(user.getUsername().equals(username))
            {
                return user;
            }
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        this.userMapper.insert(user);
    }

}