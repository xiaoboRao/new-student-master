package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Mycreative;
import cn.jxust.dq.student.entity.MycreativeExample;
import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service
public interface mycreativeservice {

    List<Mycreative> findall(MycreativeExample myvolunteerExample);
    Mycreative findbyid(int id);
    List<Mycreative> findbyitemsid(int id);
    void insert(Mycreative myvolunteer);
    void deletebypic(String pic);

}
