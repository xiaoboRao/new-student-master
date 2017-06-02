package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Myimportant;
import cn.jxust.dq.student.entity.MyimportantExample;
import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service
public interface myimportantservice {

    List<Myimportant> findall(MyimportantExample myvolunteerExample);
    Myimportant findbyid(int id);
    List<Myimportant> findbyitemsid(int id);
    void insert(Myimportant myvolunteer);
    void deletebypic(String pic);

}
