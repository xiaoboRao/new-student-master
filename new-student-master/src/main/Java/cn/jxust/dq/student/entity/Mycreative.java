package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

@Service
public class Mycreative {
    private Integer id;

    private Integer itemsId;

    private String mycreativepic;

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

    public String getMycreativepic() {
        return mycreativepic;
    }

    public void setMycreativepic(String mycreativepic) {
        this.mycreativepic = mycreativepic == null ? null : mycreativepic.trim();
    }
}