package cn.jxust.dq.student.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class User implements Serializable{
    private Integer id;

    private String username;

    private String password;

    public User(String username, String password, String email, String phone, String college, String idnumber, Byte sex, Integer classess) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.college = college;
        this.idnumber = idnumber;
        this.sex = sex;
        this.classess = classess;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", college='" + college + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", sex=" + sex +
                ", classess=" + classess +
                '}';
    }

    private String email;

    private String phone;

    private String college;

    private String idnumber;

    private Byte sex;

    private Integer classess;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getClassess() {
        return classess;
    }

    public void setClassess(Integer classess) {
        this.classess = classess;
    }
}