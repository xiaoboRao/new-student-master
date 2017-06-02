package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

@Service
public class Myimportant {
    private Integer id;

    private Integer itemsId;

    private String myimportantpic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public String getMyimportantpic() {
        return myimportantpic;
    }

    public void setMyimportantpic(String myimportantpic) {
        this.myimportantpic = myimportantpic == null ? null : myimportantpic.trim();
    }
}