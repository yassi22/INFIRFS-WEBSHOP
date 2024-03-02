package com.example.codealongw3.dao;

import com.example.codealongw3.dto.TaskDTO;
import com.example.codealongw3.models.Category;
import com.example.codealongw3.models.Task;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDao {

    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public TaskDao(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public Task getTask(long id) {
        Optional<Task> task = this.taskRepository.findById(id);

        if(task.isPresent()){
            return task.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No tasks found with that category id"
            );
        }
    }

    public List<Task> getAllTasksByCategory(long id) {
        Optional<List<Task>> tasks = this.taskRepository.findByCategoryId(id);

        if (tasks.get().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No tasks found with that category id"
            );
        }

        return tasks.get();
    }


    @Transactional
    public void createTask(Task task) {
        this.categoryRepository.save(task.getCategory());
        this.taskRepository.save(task);

    }


    @Transactional
    public void createTask(TaskDTO taskDTO) {
        Optional<Category> category = this.categoryRepository.findById(taskDTO.categoryId);

        if (category.isPresent()) {
            Task task = new Task(taskDTO.name, taskDTO.description, category.get());
            this.taskRepository.save(task);
            return;
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Category not Found");
    }


    public void updateTask(TaskDTO taskDTO, Long id) {
        Optional<Task> task = this.taskRepository.findById(id);

        if (task.isPresent()) {
            task.get().setDescription(taskDTO.description);
            task.get().setNaam(taskDTO.name);

            this.taskRepository.save(task.get());
        }

    }


    public void checkTask(Long id) {
        this.toggleTask(id, true);
    }

    public void uncheckTask(Long id) {
        this.toggleTask(id, false);
    }

    public void deleteById(Long id) {
        this.taskRepository.deleteById(id);
    }


    private void toggleTask(Long id, boolean value) {
        Optional<Task> task = this.taskRepository.findById(id);

        if (task.isPresent()) {
            task.get().setFinsihed(value);
            this.taskRepository.save(task.get());
        }
    }


}
