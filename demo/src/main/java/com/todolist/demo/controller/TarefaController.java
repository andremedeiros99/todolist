package com.todolist.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.demo.entity.Tarefa;
import com.todolist.demo.service.func.TarefaServiceFunc;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaServiceFunc tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> getAll() {
        return ResponseEntity.ok(tarefaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarefa> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.getById(id).get());
    }

    @PostMapping
    public ResponseEntity<Tarefa> save(@Valid @RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(tarefaService.save(tarefa));
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        return ResponseEntity.ok(tarefaService.save(tarefa));
    }

}
