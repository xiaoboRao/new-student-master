package cn.jxust.dq.student.service.impl;


import cn.jxust.dq.student.dao.MycreativeMapper;
import cn.jxust.dq.student.dao.MyvolunteerMapper;
import cn.jxust.dq.student.entity.Mycreative;
import cn.jxust.dq.student.entity.MycreativeExample;
import cn.jxust.dq.student.entity.Myvolunteer;
import cn.jxust.dq.student.entity.MyvolunteerExample;
import cn.jxust.dq.student.service.mycreativeservice;
import cn.jxust.dq.student.service.myvolunteerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service
public class mycreativeimpl implements mycreativeservice {
    @Autowired
    private MycreativeMapper myvolunteerMapper;
    @Override
    public List<Mycreative> findall(MycreativeExample myvolunteerExample) {
        return myvolunteerMapper.selectByExample(myvolunteerExample);
    }

    @Override
    public Mycreative findbyid(int id) {
        return myvolunteerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Mycreative> findbyitemsid(int id) {
        MycreativeExample myvolunteerExample=new MycreativeExample();
        List<Mycreative> findall = this.findall(myvolunteerExample);
        List<Mycreative> list=new ArrayList<>();
        if(findall!=null) {
            for (Mycreative myvolunteer : findall
                    ) {
                if (myvolunteer.getItemsId() == id) {
                    System.out.println("Mycreative = " + myvolunteer);
                    list.add(myvolunteer);
                }
            }
            return list;
        }

        System.out.println("mysocialserviceimpl find the empty mysocial");
        return null;
    }

    @Override
    public void insert(Mycreative mysocial) {
        myvolunteerMapper.insert(mysocial);
    }

    @Override
    public void deletebypic(String mysocial) {
        MycreativeExample mysocialExample=new MycreativeExample();
        List<Mycreative> findall = this.findall(mysocialExample);
        if(findall!=null) {
            for (Mycreative mysocials : findall
                    ) {
                if (mysocials.getMycreativepic().equals(mysocial)) {

                    myvolunteerMapper.deleteByPrimaryKey(mysocials.getId());
                }
            }
        }
    }
}
