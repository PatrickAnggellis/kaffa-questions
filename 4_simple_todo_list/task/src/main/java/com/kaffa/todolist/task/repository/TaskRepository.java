package com.kaffa.todolist.task.repository;

import com.kaffa.todolist.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
