package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class Items implements Serializable{
    private Integer id;

    private Integer userid;

    private String mygroup;

    private String mysocial;

    private String myvolunteer;

    private String mycreative;

    private String myimportant;

    private String myquality;

    public Items() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMygroup() {
        return mygroup;
    }

    public void setMygroup(String mygroup) {
        this.mygroup = mygroup == null ? null : mygroup.trim();
    }

    public String getMysocial() {
        return mysocial;
    }

    public void setMysocial(String mysocial) {
        this.mysocial = mysocial == null ? null : mysocial.trim();
    }

    public String getMyvolunteer() {
        return myvolunteer;
    }

    public void setMyvolunteer(String myvolunteer) {
        this.myvolunteer = myvolunteer == null ? null : myvolunteer.trim();
    }

    public String getMycreative() {
        return mycreative;
    }

    public void setMycreative(String mycreative) {
        this.mycreative = mycreative == null ? null : mycreative.trim();
    }

    public String getMyimportant() {
        return myimportant;
    }

    public void setMyimportant(String myimportant) {
        this.myimportant = myimportant == null ? null : myimportant.trim();
    }

    public String getMyquality() {
        return myquality;
    }

    public void setMyquality(String myquality) {
        this.myquality = myquality == null ? null : myquality.trim();
    }
}