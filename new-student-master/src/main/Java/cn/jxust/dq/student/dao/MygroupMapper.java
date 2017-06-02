package cn.jxust.dq.student.dao;

import cn.jxust.dq.student.entity.Mygroup;
import cn.jxust.dq.student.entity.MygroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MygroupMapper {
    int countByExample(MygroupExample example);

    int deleteByExample(MygroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mygroup record);

    int insertSelective(Mygroup record);

    List<Mygroup> selectByExample(MygroupExample example);

    Mygroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mygroup record, @Param("example") MygroupExample example);

    int updateByExample(@Param("record") Mygroup record, @Param("example") MygroupExample example);

    int updateByPrimaryKeySelective(Mygroup record);

    int updateByPrimaryKey(Mygroup record);
}