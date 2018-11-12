/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quizserver;

import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.core.Application;

/**
 *
 * @author erikfossum
 */
@ApplicationScoped
@javax.ws.rs.ApplicationPath("api")
@DeclareRoles({Group.ADMIN,Group.USER})
@DatabaseIdentityStoreDefinition(
    dataSourceLookup="java:app/jdbc/quiz", 
    callerQuery="select password from USERNAME where userid = ?",
    groupsQuery="select groups_name from USERGROUP_USERNAME where users_userid  = ?",
    hashAlgorithm = PasswordHash.class
)
@BasicAuthenticationMechanismDefinition(realmName = "chatrealm")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.quizserver.AuthService.class);
        resources.add(com.mycompany.quizserver.QuizManager.class);
    }
    
}
