package com.ucar.training.entity;

import java.util.List;

//角色
public class Role {
    private String name;
    private List<String> permissions;

    public Role() {}
    public Role(String name, List<String> permissions){
        this.name = name;
        this.permissions = permissions;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
    public List<String> getPermissions() {
        return permissions;
    }
}
