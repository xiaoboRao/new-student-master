package cn.jxust.dq.student.dao;

import cn.jxust.dq.student.entity.Mysocial;
import cn.jxust.dq.student.entity.MysocialExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MysocialMapper {
    int countByExample(MysocialExample example);

    int deleteByExample(MysocialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mysocial record);

    int insertSelective(Mysocial record);

    List<Mysocial> selectByExample(MysocialExample example);

    Mysocial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mysocial record, @Param("example") MysocialExample example);

    int updateByExample(@Param("record") Mysocial record, @Param("example") MysocialExample example);

    int updateByPrimaryKeySelective(Mysocial record);

    int updateByPrimaryKey(Mysocial record);
}