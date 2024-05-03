package com.caroline.apitarefas.controller;

import com.caroline.apitarefas.entity.Todo;
import com.caroline.apitarefas.repository.TodoRepository;
import com.caroline.apitarefas.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @PostMapping
    public ResponseEntity<Todo>create(@RequestBody Todo todo){
        this.todoService.create(todo);
        return new ResponseEntity<Todo>(HttpStatus.CREATED);
    }

    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }

    @PutMapping()
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable Long id){
        return todoService.delete(id);
    }

}
