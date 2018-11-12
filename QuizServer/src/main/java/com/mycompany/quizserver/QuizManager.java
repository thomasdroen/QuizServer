/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quizserver;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author erikfossum
 */
@Stateless
@Path("quiz")
public class QuizManager {
    
    @PersistenceContext
    EntityManager em;
    
    @GET
    public String getHello() {
        return "Hello";
    }
    
    @GET
    @Path("getCategories")
    @RolesAllowed({Group.USER})
    public List<Category> getConversations(){
        return em.createQuery("SELECT c FROM Category c").getResultList();
    } 
    
    
    
    
    
    
    
}
