package com.ly.shiro.entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class User {
    private String id;
    private String username;
    private String password;

    private Set<Role> roles;
}
