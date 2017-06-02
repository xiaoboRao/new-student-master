package cn.jxust.dq.student.dao;


import cn.jxust.dq.student.entity.Mycreative;
import cn.jxust.dq.student.entity.MycreativeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MycreativeMapper {
    int countByExample(MycreativeExample example);

    int deleteByExample(MycreativeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mycreative record);

    int insertSelective(Mycreative record);

    List<Mycreative> selectByExample(MycreativeExample example);

    Mycreative selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mycreative record, @Param("example") MycreativeExample example);

    int updateByExample(@Param("record") Mycreative record, @Param("example") MycreativeExample example);

    int updateByPrimaryKeySelective(Mycreative record);

    int updateByPrimaryKey(Mycreative record);
}