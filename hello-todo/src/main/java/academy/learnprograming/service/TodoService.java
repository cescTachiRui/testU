/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academy.learnprograming.service;

import academy.learnprograming.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Cesc'
 */
@Transactional 
public class TodoService {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public Todo createTodo(Todo todo){
        //Persisnt into db
        entityManager.persist(todo);
        return todo;
    }
    
    public Todo updateTodo(Todo todo){
        entityManager.merge(todo);
        return todo;
    }
    
    public Todo findTodobyId(Long id){
        return entityManager.find(Todo.class, id);
    }
    
    public List<Todo> getTodos(){
        return entityManager.createQuery("SELECT t from Todo t ",Todo.class).getResultList();
    }
}
