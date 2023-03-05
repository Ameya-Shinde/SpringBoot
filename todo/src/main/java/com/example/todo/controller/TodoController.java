package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Create todo, delete todo, update todo, fetch todo from CRUD Operation
*
* */
@RestController
@RequestMapping("/api/v1/todo-app")
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService){
    this.todoService = todoService;
  }

  //http://localhost:8080/api/v1/todo-app/add-todo
    @PostMapping("/add-todo")
    public void addTodo(@RequestBody Todo todo){
      todoService.addTodo(todo);
    }

  //http://localhost:8080/api/v1/todo-app/find-todo/id/3
  @GetMapping("/find-todo/id/{id}")
  public Todo findTodoById(@PathVariable int id){
    return todoService.findById(id);
  }

  //http://localhost:8080/api/v1/todo-app/find-all
  @GetMapping("find-all")
  public List<Todo> findAllTodos(){
    return todoService.findAll();
  }

  //http://localhost:8080/api/v1/todo-app/update-todo/id/{id}
  @PutMapping("/update-todo/id/{id}")
  public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
    todoService.updateTodo(id, todo);
  }

  //http://localhost:8080/api/v1/todo-app/delete-todo/id/{id}
  @DeleteMapping("/delete-todo/id/{id}")
  public void deleteTodo(@PathVariable int id){
    todoService.deleteTodo(id);
  }

  @RequestMapping("/api/username/{username}")
  public String helloUser(@PathVariable String username){
      return "Welcome " + username;
  }
}
