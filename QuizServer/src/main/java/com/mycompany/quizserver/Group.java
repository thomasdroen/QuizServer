/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quizserver;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



/**
 *
 * @author erikfossum
 */
@Entity 
@Table(name = "USERGROUP")
public class Group implements Serializable{
    public static final String USER = "user";
    public static final String ADMIN = "admin";
    public static final String[] GROUPS = {USER, ADMIN};

    @Id
    String name;

    @ManyToMany()
    Set<User> users;

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{" + "name=" + name + '}';
    }
    
    
}