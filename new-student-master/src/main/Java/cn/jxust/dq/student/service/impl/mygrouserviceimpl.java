package cn.jxust.dq.student.service.impl;

import cn.jxust.dq.student.dao.MygroupMapper;
import cn.jxust.dq.student.entity.Mygroup;
import cn.jxust.dq.student.entity.MygroupExample;
import cn.jxust.dq.student.service.mygroupservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service
public class mygrouserviceimpl implements mygroupservice {
    @Autowired
    private MygroupMapper mygroupMapper;
    @Override
    public List<Mygroup> findall(MygroupExample mygroupExample) {
        return mygroupMapper.selectByExample(mygroupExample);
    }

    @Override
    public Mygroup findbyid(int id) {
        return mygroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Mygroup> findbyitemsid(int id) {
        MygroupExample mygroupExample=new MygroupExample();
        List<Mygroup> findall = this.findall(mygroupExample);
        List<Mygroup> list=new ArrayList<>();
        if(findall.size()!=0) {
            for (Mygroup mygroup : findall
                    ) {
                if (mygroup.getItemsId() == id) {
                    System.out.println("mygroup = " + mygroup);
                    list.add(mygroup);
                }
            }
            return list;
        }

            System.out.println("mygroupserviceimpl find the empty mygroup");
        return null;
    }

    @Override
    public void insert(Mygroup mygroup) {
        mygroupMapper.insert(mygroup);
    }

    @Override
    public void deletebygrouppic(String mygroup) {
        MygroupExample mygroupExample=new MygroupExample();
        List<Mygroup> findall = this.findall(mygroupExample);
        for (Mygroup mygroups:findall
             ) {
            if(mygroups.getMygrouppic().equals(mygroup))
            {
                mygroupMapper.deleteByPrimaryKey(mygroups.getId());
            }
        }
    }
}
