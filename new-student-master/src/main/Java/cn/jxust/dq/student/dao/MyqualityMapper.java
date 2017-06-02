package cn.jxust.dq.student.dao;


import cn.jxust.dq.student.entity.Myquality;
import cn.jxust.dq.student.entity.MyqualityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyqualityMapper {
    int countByExample(MyqualityExample example);

    int deleteByExample(MyqualityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Myquality record);

    int insertSelective(Myquality record);

    List<Myquality> selectByExample(MyqualityExample example);

    Myquality selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Myquality record, @Param("example") MyqualityExample example);

    int updateByExample(@Param("record") Myquality record, @Param("example") MyqualityExample example);

    int updateByPrimaryKeySelective(Myquality record);

    int updateByPrimaryKey(Myquality record);
}