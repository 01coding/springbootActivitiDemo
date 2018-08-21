package com.zjrodger.modules.system.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjian
 * @create 2018-08-21
 */
public class Role {

    private Integer rid;

    private Integer rname;

    private Set<Permission> permissions = new HashSet<>();

    private Set<User> users = new HashSet<>();

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRname() {
        return rname;
    }

    public void setRname(Integer rname) {
        this.rname = rname;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname=" + rname +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }
}
