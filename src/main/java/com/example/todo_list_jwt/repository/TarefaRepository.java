package com.example.todo_list_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_list_jwt.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
}
