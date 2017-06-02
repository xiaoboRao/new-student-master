package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

@Service
public class Myvolunteer {
    private Integer id;

    private Integer itemsId;

    private String myvolunteerpic;

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

    public String getMyvolunteerpic() {
        return myvolunteerpic;
    }

    public void setMyvolunteerpic(String myvolunteerpic) {
        this.myvolunteerpic = myvolunteerpic == null ? null : myvolunteerpic.trim();
    }
}