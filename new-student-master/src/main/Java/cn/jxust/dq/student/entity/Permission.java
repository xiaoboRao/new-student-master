package cn.jxust.dq.student.entity;

public class Permission {
    private Integer id;

    private String name;

    private String type;

    private String url;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getAvalable() {
        return avalable;
    }

    public void setAvalable(Byte avalable) {
        this.avalable = avalable;
    }
}