package cn.jxust.dq.student.service.impl;


import cn.jxust.dq.student.dao.MysocialMapper;
import cn.jxust.dq.student.entity.Mysocial;
import cn.jxust.dq.student.entity.MysocialExample;
import cn.jxust.dq.student.service.mysocialservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service
public class mysoicalserviceimpl implements mysocialservice {
    @Autowired
    private MysocialMapper mysocialMapper;
    @Override
    public List<Mysocial> findall(MysocialExample mysocialExample) {
        return mysocialMapper.selectByExample(mysocialExample);
    }

    @Override
    public Mysocial findbyid(int id) {
        return mysocialMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Mysocial> findbyitemsid(int id) {
        MysocialExample mysocialExample=new MysocialExample();
        List<Mysocial> findall = this.findall(mysocialExample);
        List<Mysocial> list=new ArrayList<>();
        if(findall!=null) {
            for (Mysocial mysocial : findall
                    ) {
                if (mysocial.getItemsId() == id) {
                    System.out.println("mysocial = " + mysocial);
                    list.add(mysocial);
                }
            }
            return list;
        }

        System.out.println("mysocialserviceimpl find the empty mysocial");
        return null;
    }

    @Override
    public void insert(Mysocial mysocial) {
        mysocialMapper.insert(mysocial);
    }

    @Override
    public void deletebygrouppic(String mysocial) {
        MysocialExample mysocialExample=new MysocialExample();
        List<Mysocial> findall = this.findall(mysocialExample);
        for (Mysocial mysocials:findall
                ) {
            if(mysocials.getMysocialpic().equals(mysocial))
            {
                mysocialMapper.deleteByPrimaryKey(mysocials.getId());
            }
        }
    }
}
