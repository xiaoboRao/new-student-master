package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

@Service
public class Myquality {
    private Integer id;

    private Integer itemsId;

    private String myqualitypic;

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

    public String getMyqualitypic() {
        return myqualitypic;
    }

    public void setMyqualitypic(String myqualitypic) {
        this.myqualitypic = myqualitypic == null ? null : myqualitypic.trim();
    }
}