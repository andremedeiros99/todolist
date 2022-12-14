package com.todolist.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
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

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaServiceFunc tarefaService;

    @GetMapping
    public ResponseEntity<Page<Tarefa>> getAll(Pageable pageable) {
        return ResponseEntity.ok(tarefaService.findAll(pageable));
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
