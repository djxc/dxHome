package com.djxc.study.web.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 权限认证实体类
 */
public class AuthUser {
    private int id;
    private String name;
    private String passwd;
    private int authority;
    private Collection<? extends GrantedAuthority> role;

    public AuthUser() {}

    public AuthUser(int id, String name, String passwd, int authority, Collection<? extends GrantedAuthority> role) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.authority = authority;
        this.role = role;
    }

    public Collection<? extends GrantedAuthority> getRole() {
        return role;
    }

    public void setRole(Collection<? extends GrantedAuthority> role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
