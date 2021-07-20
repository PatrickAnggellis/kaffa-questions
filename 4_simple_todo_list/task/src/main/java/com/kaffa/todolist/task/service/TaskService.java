package com.kaffa.todolist.task.service;

import com.kaffa.todolist.task.dto.TaskDTO;
import com.kaffa.todolist.task.entity.Task;
import com.kaffa.todolist.task.mapper.TaskMapper;
import com.kaffa.todolist.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    //List all tasks
    public List<TaskDTO> listAll () {
        List<Task> allTask = taskRepository.findAll();
        return allTask.stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
    }




}
