/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quizserver;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import static com.mycompany.quizserver.User.FIND_ALL_USERS;
import static com.mycompany.quizserver.User.FIND_USER_BY_IDS;
import javax.persistence.NamedQueries;

/**
 *
 * @author erikfossum
 */
@Entity @Table(name = "USERNAME")
@NamedQueries({
@NamedQuery(name = FIND_USER_BY_IDS, query = "select u from User u where u.userId in :ids")})
public class User implements Serializable {
    public static final String FIND_USER_BY_IDS = "User.findUserByIds";
    public static final String FIND_ALL_USERS = "User.findAllUsers";

    @Id
    private String userId;
    
    @JsonbTransient
    String password;
    
    @JsonbTransient
    @ManyToMany(mappedBy = "users")
    Set<Group> groups;
    
    public enum State {
        ACTIVE, INACTIVE
    }
    @Enumerated(EnumType.STRING)
    State currentState = State.ACTIVE;

    public User(String userId) {
        this.userId = userId;
    }
    
    public User(){
        
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    
    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }
    
       public void addGroup(Group group) {
        getGroups().add(group);
        group.getUsers().add(this);
    }

    public Set<Group> getGroups() {
        if(groups == null) {
            groups = new HashSet<>();
        }
        return groups;
    }


    @Override
    public String toString() {
        return "com.mycompany.quizserver.User[ id=" + userId + " ]";
    }
    
}
