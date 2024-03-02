package com.example.codealongw3.controller;

import com.example.codealongw3.dao.TaskDao;
import com.example.codealongw3.dto.TaskDTO;
import com.example.codealongw3.models.Task;
import jakarta.persistence.Id;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskDao taskDao;

    public TaskController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskDao.getAllTasks());

    }


    @PostMapping()
    public ResponseEntity<String> createTask(@RequestBody TaskDTO taskDTO) {
        try {
            this.taskDao.createTask(taskDTO);
            return ResponseEntity.ok("Created a task");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        this.taskDao.updateTask(taskDTO, id);
        return ResponseEntity.ok("Task is updated" + id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        try {
            Task task = this.taskDao.getTask(id);
            return ResponseEntity.ok(task);
        } catch (ResponseStatusException e) {
            return ResponseEntity.badRequest().build();
        }
    }



    @PutMapping("check/{id}")
    public ResponseEntity<String> checkTask(@PathVariable Long id) {
        this.taskDao.checkTask(id);
        return ResponseEntity.ok("Task is check" + id);
    }

    @PutMapping("uncheck/{id}")
    public ResponseEntity<String> uncheckTask(@PathVariable Long id) {
        this.taskDao.uncheckTask(id);
        return ResponseEntity.ok("Task is uncheck" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        this.taskDao.deleteById(id);
        return ResponseEntity.ok("Task is deleted");
    }


}
