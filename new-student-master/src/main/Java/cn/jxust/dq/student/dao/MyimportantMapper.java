package cn.jxust.dq.student.dao;


import cn.jxust.dq.student.entity.Myimportant;
import cn.jxust.dq.student.entity.MyimportantExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyimportantMapper {
    int countByExample(MyimportantExample example);

    int deleteByExample(MyimportantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Myimportant record);

    int insertSelective(Myimportant record);

    List<Myimportant> selectByExample(MyimportantExample example);

    Myimportant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Myimportant record, @Param("example") MyimportantExample example);

    int updateByExample(@Param("record") Myimportant record, @Param("example") MyimportantExample example);

    int updateByPrimaryKeySelective(Myimportant record);

    int updateByPrimaryKey(Myimportant record);
}