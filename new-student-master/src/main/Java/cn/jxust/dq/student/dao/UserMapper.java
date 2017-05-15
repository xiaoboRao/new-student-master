package cn.jxust.dq.student.dao;

import cn.jxust.dq.student.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(String username);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}