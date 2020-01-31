package com.venkatesh.dbdemowithangular8.bean;

public class Userbean {
    private Integer id;
    private String username;
    private String role;
    private Byte ismodify;

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
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Byte getIsmodify() {
        return ismodify;
    }

    public void setIsmodify(Byte ismodify) {
        this.ismodify = ismodify;
    }
}
