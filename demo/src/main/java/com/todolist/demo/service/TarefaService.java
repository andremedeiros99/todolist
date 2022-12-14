package com.todolist.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.todolist.demo.entity.Tarefa;

public interface TarefaService {

    public Page<Tarefa> findAll(Pageable pageable);

    public Optional<Tarefa> getById(Long id);

    public Tarefa save(Tarefa tarefa);

    void deleteById(Long id);

    Tarefa update(Tarefa tarefa);

}
