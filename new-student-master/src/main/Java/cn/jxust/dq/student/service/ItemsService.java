package cn.jxust.dq.student.service;

import cn.jxust.dq.student.entity.Items;
import cn.jxust.dq.student.entity.ItemsExample;

import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
public interface ItemsService {
    List<Items> findall(ItemsExample itemsExample);
    List<Items> findbyuserid(int id);
    void insert(Items items);
    Items findbyid(int id);
    List<Items> findbymygroup(String mygroup);
    List<Items> findallitems(ItemsExample itemsExample);
    void updateitems(Items items);
}
