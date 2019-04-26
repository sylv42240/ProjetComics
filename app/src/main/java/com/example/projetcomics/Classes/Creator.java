package com.example.projetcomics.Classes;

import java.io.Serializable;

public class Creator implements Serializable {
    private String name;
    private String role;

    public Creator(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
