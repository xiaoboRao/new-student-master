package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
@Service
public class activityuser implements Serializable{
    private String username;
    private  String password;
    private int userid;
    private List<String> permissions;
    private String college;
    private int classes;

    public String[] getMysocialpic() {
        return mysocialpic;
    }

    public void setMysocialpic(String[] mysocialpic) {
        this.mysocialpic = mysocialpic;
    }

    public String[] getMyvolunteerpic() {
        return myvolunteerpic;
    }

    public void setMyvolunteerpic(String[] myvolunteerpic) {
        this.myvolunteerpic = myvolunteerpic;
    }

    public String[] getMycreativepic() {
        return mycreativepic;
    }

    public void setMycreativepic(String[] mycreativepic) {
        this.mycreativepic = mycreativepic;
    }

    public String[] getMyimportantpic() {
        return myimportantpic;
    }

    public void setMyimportantpic(String[] myimportantpic) {
        this.myimportantpic = myimportantpic;
    }

    public String[] getMyqualitypic() {
        return myqualitypic;
    }

    public void setMyqualitypic(String[] myqualitypic) {
        this.myqualitypic = myqualitypic;
    }

    private String idnumber;
    private String[] mysocialpic;
    private String[] myvolunteerpic;
    private String[] mycreativepic;
    private String[] myimportantpic;
    private String[] myqualitypic;
    public Mygroup getMygroup() {
        return mygroup;
    }

    public void setMygroup(Mygroup mygroup) {
        this.mygroup = mygroup;
    }

    private Mygroup mygroup;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    private Items item;


    public String[] getMygrouppic() {
        return mygrouppic;
    }

    public void setMygrouppic(String[] mygrouppic) {
        this.mygrouppic = mygrouppic;
    }

    private String[] mygrouppic;
    public activityuser() {
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }


    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "activityuser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userid=" + userid +
                ", permissions=" + permissions +
                ", college='" + college + '\'' +
                ", classes=" + classes +
                ", idnumber='" + idnumber + '\'' +
                ", mygrouppic='" + mygrouppic + '\'' +
                '}';
    }
}
