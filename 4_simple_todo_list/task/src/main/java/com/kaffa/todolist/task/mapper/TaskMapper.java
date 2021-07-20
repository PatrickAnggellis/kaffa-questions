package com.kaffa.todolist.task.mapper;

import com.kaffa.todolist.task.dto.TaskDTO;
import com.kaffa.todolist.task.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task toModel(TaskDTO taskDTO);

    TaskDTO toDTO(Task task);
}
