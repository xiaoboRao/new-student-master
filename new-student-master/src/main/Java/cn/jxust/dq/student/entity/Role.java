package cn.jxust.dq.student.entity;

public class Role {
    private Integer id;

    private String name;

    private Byte avalable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getAvalable() {
        return avalable;
    }

    public void setAvalable(Byte avalable) {
        this.avalable = avalable;
    }
}