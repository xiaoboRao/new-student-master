package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Myquality;
import cn.jxust.dq.student.entity.MyqualityExample;
import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service
public interface myqualityservice {

    List<Myquality> findall(MyqualityExample myvolunteerExample);
    Myquality findbyid(int id);
    List<Myquality> findbyitemsid(int id);
    void insert(Myquality myvolunteer);
    void deletebypic(String pic);

}
