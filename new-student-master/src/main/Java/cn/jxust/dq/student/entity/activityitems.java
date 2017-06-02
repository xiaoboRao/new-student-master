package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Service
public class activityitems implements Serializable{
    private String username;
    private  String password;
    private int userid;
    private List<String> permissions;
    private String college;
    private int classes;
    private String idnumber;
    private Items item;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public Mygroup getMygroup() {
        return mygroup;
    }

    public void setMygroup(Mygroup mygroup) {
        this.mygroup = mygroup;
    }

    private Mygroup mygroup;

    public Items getItems() {
        return item;
    }

    public void setItems(Items Items) {
        this.item= Items;
    }

    public activityitems(String username, String password, int userid, String college, int classes, String idnumber, String[] mygrouppic) {
        this.username = username;
        this.password = password;
        this.userid = userid;
        this.college = college;
        this.classes = classes;
        this.idnumber = idnumber;
        this.mygrouppic = mygrouppic;
    }

    public String[] getMygrouppic() {
        return mygrouppic;
    }

    public void setMygrouppic(String[] mygrouppic) {
        this.mygrouppic = mygrouppic;
    }

    private String[] mygrouppic;

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

    private String[] mysocialpic;
    private String[] myvolunteerpic;
    private String[] mycreativepic;
    private String[] myimportantpic;
    private String[] myqualitypic;
    public activityitems() {
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
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

    @Override
    public String toString() {
        return "activityitems{" +
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
