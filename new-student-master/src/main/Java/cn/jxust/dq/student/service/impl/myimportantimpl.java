package cn.jxust.dq.student.service.impl;


import cn.jxust.dq.student.dao.MyimportantMapper;
import cn.jxust.dq.student.dao.MyvolunteerMapper;
import cn.jxust.dq.student.entity.Myimportant;
import cn.jxust.dq.student.entity.MyimportantExample;
import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import cn.jxust.dq.student.service.myimportantservice;
import cn.jxust.dq.student.service.myvolunteerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service
public class myimportantimpl implements myimportantservice {
    @Autowired
    private MyimportantMapper myimportantMapper;
    @Override
    public List<Myimportant> findall(MyimportantExample myvolunteerExample) {
        return myimportantMapper.selectByExample(myvolunteerExample);
    }

    @Override
    public Myimportant findbyid(int id) {
        return myimportantMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Myimportant> findbyitemsid(int id) {
        MyimportantExample myvolunteerExample=new MyimportantExample();
        List<Myimportant> findall = this.findall(myvolunteerExample);
        List<Myimportant> list=new ArrayList<>();
        if(findall!=null) {
            for (Myimportant myvolunteer : findall
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
    public void insert(Myimportant mysocial) {
        myimportantMapper.insert(mysocial);
    }

    @Override
    public void deletebypic(String mysocial) {
        MyimportantExample mysocialExample=new MyimportantExample();
        List<Myimportant> findall = this.findall(mysocialExample);
        if(findall!=null) {
            for (Myimportant mysocials : findall
                    ) {
                if (mysocials.getMyimportantpic().equals(mysocial)) {
                    myimportantMapper.deleteByPrimaryKey(mysocials.getId());
                }
            }
        }
    }
}
