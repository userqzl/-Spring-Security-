package cn.qzlin.enity;

import org.apache.ibatis.annotations.Insert;

/**
 * @description: 权限实体类
 * @author: qzl
 * @created: 2021/02/01 10:35
 */

public class Authority {
    private Insert id;
    private String authority_name;
    private String note;

    public Insert getId() {
        return id;
    }

    public void setId(Insert id) {
        this.id = id;
    }

    public String getAuthority_name() {
        return authority_name;
    }

    public void setAuthority_name(String authority_name) {
        this.authority_name = authority_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority_name='" + authority_name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
