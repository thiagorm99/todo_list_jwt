package com.example.todo_list_jwt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo_list_jwt.model.Tarefa;
import com.example.todo_list_jwt.repository.TarefaRepository;
  
@Service
public class TarefaService {
    
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository){
        this.repository = repository;
    }
    
    public List<Tarefa> listar(){
        return repository.findAll();
    }

    public Tarefa salvar(Tarefa t){
        return repository.save(t);
    }

    public Tarefa buscar(Long id){
        return repository.findById(id).orElseThrow();
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
