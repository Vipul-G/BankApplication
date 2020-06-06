package com.prafful.bank.BankApplication.User;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull private String password;
    @NotNull private String role;
    @NotNull private boolean active;

    public User(String password, String role) {
        this.password = password;
        this.role = role;
        this.active = true;
    }

    public User() {}


    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
