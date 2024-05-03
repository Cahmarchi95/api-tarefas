package com.caroline.apitarefas.repository;

import com.caroline.apitarefas.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
