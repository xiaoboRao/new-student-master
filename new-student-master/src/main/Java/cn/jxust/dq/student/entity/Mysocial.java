package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

@Service
public class Mysocial {
    private Integer id;

    private Integer itemsId;

    private String mysocialpic;

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

    public String getMysocialpic() {
        return mysocialpic;
    }

    public void setMysocialpic(String mysocialpic) {
        this.mysocialpic = mysocialpic == null ? null : mysocialpic.trim();
    }
}