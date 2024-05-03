package com.caroline.apitarefas.service;

import com.caroline.apitarefas.entity.Todo;
import com.caroline.apitarefas.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public List<Todo> create(Todo tarefa){
        todoRepository.save(tarefa);
        return list();
    }

    public List<Todo> list(){
       Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }


}
