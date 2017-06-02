package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

@Service
public class Mygroup {
    private Integer id;

    private Integer itemsId;

    private String mygrouppic;

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

    public String getMygrouppic() {
        return mygrouppic;
    }

    public void setMygrouppic(String mygrouppic) {
        this.mygrouppic = mygrouppic == null ? null : mygrouppic.trim();
    }

    @Override
    public String toString() {
        return "Mygroup{" +
                "id=" + id +
                ", itemsId=" + itemsId +
                ", mygrouppic='" + mygrouppic + '\'' +
                '}';
    }
}