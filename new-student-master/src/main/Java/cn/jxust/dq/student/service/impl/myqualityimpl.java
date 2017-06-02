package cn.jxust.dq.student.service.impl;


import cn.jxust.dq.student.dao.MyqualityMapper;
import cn.jxust.dq.student.dao.MyvolunteerMapper;
import cn.jxust.dq.student.entity.Myquality;
import cn.jxust.dq.student.entity.MyqualityExample;
import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import cn.jxust.dq.student.service.myqualityservice;
import cn.jxust.dq.student.service.myvolunteerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service
public class myqualityimpl implements myqualityservice {
    @Autowired
    private MyqualityMapper myqualityMapper;
    @Override
    public List<Myquality> findall(MyqualityExample myvolunteerExample) {
        return myqualityMapper.selectByExample(myvolunteerExample);
    }

    @Override
    public Myquality findbyid(int id) {
        return myqualityMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Myquality> findbyitemsid(int id) {
        MyqualityExample myvolunteerExample=new MyqualityExample();
        List<Myquality> findall = this.findall(myvolunteerExample);
        List<Myquality> list=new ArrayList<>();
        if(findall!=null) {
            for (Myquality myvolunteer : findall
                    ) {
                if (myvolunteer.getItemsId() == id) {
                    System.out.println("mysocial = " + myvolunteer);
                    list.add(myvolunteer);
                }
            }
            return list;
        }

        System.out.println("mysocialserviceimpl find the empty mysocial");
        return null;
    }

    @Override
    public void insert(Myquality mysocial) {
        myqualityMapper.insert(mysocial);
    }

    @Override
    public void deletebypic(String mysocial) {
        MyqualityExample mysocialExample=new MyqualityExample();
        List<Myquality> findall = this.findall(mysocialExample);
        if(findall!=null) {
            for (Myquality mysocials : findall
                    ) {
                if (mysocials.getMyqualitypic().equals(mysocial)) {
                    myqualityMapper.deleteByPrimaryKey(mysocials.getId());
                }
            }
        }
    }
}
