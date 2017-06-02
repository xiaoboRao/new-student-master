package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Mygroup;
import cn.jxust.dq.student.entity.MygroupExample;
import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service
public interface myvolunteerservice {

    List<Myvolunteer> findall(MyvolunteerExample myvolunteerExample);
    Myvolunteer findbyid(int id);
    List<Myvolunteer> findbyitemsid(int id);
    void insert(Myvolunteer myvolunteer);
    void deletebypic(String pic);

}
