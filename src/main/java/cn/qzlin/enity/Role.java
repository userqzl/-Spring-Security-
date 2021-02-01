package cn.qzlin.enity;

import java.util.List;

/**
 * @description: 角色
 * @author: qzl
 * @created: 2021/01/31 17:18
 */

public class Role {
    private Integer id;
    private String role_name;
    private String note;
    private List<Authority> authorityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", note='" + note + '\'' +
                ", authorityList=" + authorityList +
                '}';
    }
}
