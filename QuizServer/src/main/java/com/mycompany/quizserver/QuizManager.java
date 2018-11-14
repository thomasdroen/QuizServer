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
import javax.ws.rs.POST;
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
    public List<Category> getConversations(){
        return em.createQuery("SELECT c FROM Category c").getResultList();
    } 
    
    @GET
    @Path("getQuestions")
    public List<Questions> getquestions(@QueryParam("category") String category){
        return em.createQuery("SELECT q FROM Questions q WHERE q.category = :category")
                .setParameter("category", category)
                .getResultList();
    }
    
    @POST
    @Path("addQuestion")
    public Questions createQuestion(Questions questions){
        Questions result = new Questions();
        result.setQuestion(questions.getQuestion());
        result.setAlternative1(questions.getAlternative1());
        result.setAlternative2(questions.getAlternative2());
        result.setAlternative3(questions.getAlternative3());
        result.setAlternative4(questions.getAlternative4());
        result.setCorrectAnswer(questions.getCorrectAnswer());
        result.setCategory(questions.getCategory());
        em.persist(result);
        return result;
    }
    
    @POST
    @Path("addCategory")
    public Category createCategory(Category category){
        Category result = new Category();
        result.setCategoryName(category.getCategoryName());
        em.persist(result);
        return result;
    }
    
    
    
    
    
}
