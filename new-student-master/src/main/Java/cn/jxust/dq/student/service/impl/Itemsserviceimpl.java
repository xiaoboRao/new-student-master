package cn.jxust.dq.student.service.impl;

import cn.jxust.dq.student.dao.ItemsMapper;
import cn.jxust.dq.student.entity.Items;
import cn.jxust.dq.student.entity.ItemsExample;
import cn.jxust.dq.student.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service
public class Itemsserviceimpl implements ItemsService{
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public List<Items> findall(ItemsExample itemsExample) {
        return itemsMapper.selectByExample(itemsExample);
    }

    @Override
    public List<Items> findbyuserid(int id) {
        ItemsExample itemsExample=new ItemsExample();
        List<Items> items = this.findall(itemsExample);
        List<Items> list=new ArrayList<>();
        if(items.size()!=0) {
            for (int i = 0; i < items.size(); i++) {

                if (items.get(i).getUserid() == id) {
                    list.add(items.get(i));
                }
            }
            return list;
        }
        return null;
    }

    @Override
    public void insert(Items items) {
        itemsMapper.insert(items);
    }

    @Override
    public Items findbyid(int id) {
        return itemsMapper.selectByPrimaryKey(id);
    }



    @Override
    public List<Items> findbymygroup(String mygroup) {
        ItemsExample itemsExample=new ItemsExample();
        List<Items> findall = this.findall(itemsExample);
        List<Items> list=new ArrayList<>();
        for (Items item:findall
                ) {
            if(item.getMygroup().equals(mygroup))
            {
                Integer id = item.getId();
                System.out.println("id = " + id);
                Items items = itemsMapper.selectByPrimaryKey(id);
                list.add(items);
            }
        }
        return list;
}

    @Override
    public List<Items> findallitems(ItemsExample itemsExample) {
        return itemsMapper.selectByExample(itemsExample);
    }

    @Override
    public void updateitems(Items items) {
        itemsMapper.updateByPrimaryKeySelective(items);
    }
}
