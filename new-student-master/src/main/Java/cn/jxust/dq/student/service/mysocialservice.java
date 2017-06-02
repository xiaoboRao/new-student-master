package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Mygroup;
import cn.jxust.dq.student.entity.MygroupExample;
import cn.jxust.dq.student.entity.Mysocial;
import cn.jxust.dq.student.entity.MysocialExample;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
public interface mysocialservice {

    List<Mysocial> findall(MysocialExample MysocialExample);
    Mysocial findbyid(int id);
    List<Mysocial> findbyitemsid(int id);
    void insert(Mysocial mysocial);
    void deletebygrouppic(String mysocial);

}
