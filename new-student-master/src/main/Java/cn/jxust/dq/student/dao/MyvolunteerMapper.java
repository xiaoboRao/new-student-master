package cn.jxust.dq.student.dao;


import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyvolunteerMapper {
    int countByExample(MyvolunteerExample example);

    int deleteByExample(MyvolunteerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Myvolunteer record);

    int insertSelective(Myvolunteer record);

    List<Myvolunteer> selectByExample(MyvolunteerExample example);

    Myvolunteer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Myvolunteer record, @Param("example") MyvolunteerExample example);

    int updateByExample(@Param("record") Myvolunteer record, @Param("example") MyvolunteerExample example);

    int updateByPrimaryKeySelective(Myvolunteer record);

    int updateByPrimaryKey(Myvolunteer record);
}