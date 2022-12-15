package com.todolist.demo.service;

import java.util.Optional;

import com.todolist.demo.entity.Tarefa;
import java.util.List;

public interface TarefaService {

    public List<Tarefa> findAll();

    public Optional<Tarefa> getById(Long id);

    public Tarefa save(Tarefa tarefa);

    void deleteById(Long id);

    Tarefa update(Tarefa tarefa);

}
