package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Mygroup;
import cn.jxust.dq.student.entity.MygroupExample;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
public interface mygroupservice {

    List<Mygroup> findall(MygroupExample mygroupExample);
    Mygroup findbyid(int id);
    List<Mygroup> findbyitemsid(int id);
    void insert(Mygroup mygroup);
    void deletebygrouppic(String mygroup);

}
