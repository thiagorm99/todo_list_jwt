package com.example.todo_list_jwt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_list_jwt.model.Tarefa;
import com.example.todo_list_jwt.service.TarefaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    
    private final TarefaService service;

    public TarefaController(TarefaService service){
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas as tarefas")
    public List<Tarefa> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar tarefa por id")
    public Tarefa buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PostMapping
    @Operation(summary = "Cadastar uma tarefa")
    public Tarefa criar(@RequestBody Tarefa t){
        return service.salvar(t);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dados da tarefa")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa t){
        t.setId(id);
        return service.salvar(t);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar tarefa por id")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
