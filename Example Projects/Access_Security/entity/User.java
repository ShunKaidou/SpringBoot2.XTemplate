package com.wecp.w3day5task1.entity;


import javax.persistence.*;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true, nullable=false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String roles;

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    


    // Create a User entity with fields: id (type Long), username (type String), password (type String), roles (type String).
    // implement getter and setters

}
