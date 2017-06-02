package cn.jxust.dq.student.service.impl;


import cn.jxust.dq.student.dao.MysocialMapper;
import cn.jxust.dq.student.dao.MyvolunteerMapper;
import cn.jxust.dq.student.entity.Mysocial;
import cn.jxust.dq.student.entity.MysocialExample;
import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import cn.jxust.dq.student.service.mysocialservice;
import cn.jxust.dq.student.service.myvolunteerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service
public class myvolunteerimpl implements myvolunteerservice {
    @Autowired
    private MyvolunteerMapper myvolunteerMapper;
    @Override
    public List<Myvolunteer> findall(MyvolunteerExample myvolunteerExample) {
        return myvolunteerMapper.selectByExample(myvolunteerExample);
    }

    @Override
    public Myvolunteer findbyid(int id) {
        return myvolunteerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Myvolunteer> findbyitemsid(int id) {
        MyvolunteerExample myvolunteerExample=new MyvolunteerExample();
        List<Myvolunteer> findall = this.findall(myvolunteerExample);
        List<Myvolunteer> list=new ArrayList<>();
        if(findall!=null) {
            for (Myvolunteer myvolunteer : findall
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
    public void insert(Myvolunteer mysocial) {
        myvolunteerMapper.insert(mysocial);
    }

    @Override
    public void deletebypic(String mysocial) {
        MyvolunteerExample mysocialExample=new MyvolunteerExample();
        List<Myvolunteer> findall = this.findall(mysocialExample);
        if(findall!=null) {
            for (Myvolunteer mysocials : findall
                    ) {
                if (mysocials.getMyvolunteerpic().equals(mysocial)) {
                    myvolunteerMapper.deleteByPrimaryKey(mysocials.getId());
                }
            }
        }
    }
}
