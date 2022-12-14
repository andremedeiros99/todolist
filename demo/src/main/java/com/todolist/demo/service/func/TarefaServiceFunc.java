package com.todolist.demo.service.func;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.todolist.demo.entity.Tarefa;
import com.todolist.demo.repository.TarefaRepository;
import com.todolist.demo.service.TarefaService;

import java.util.List;

@Service
public class TarefaServiceFunc implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    @Override
    public Optional<Tarefa> getById(Long id) {
        return tarefaRepository.findById(id);
    }

    @Override
    public Tarefa save(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Override
    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }

    @Override
    public Tarefa update(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }
}
