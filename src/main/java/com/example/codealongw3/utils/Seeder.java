package com.example.codealongw3.utils;

import com.example.codealongw3.dao.TaskDao;
import com.example.codealongw3.dao.TaskRepository;
import com.example.codealongw3.models.Category;
import com.example.codealongw3.models.Task;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Seeder {

    private TaskDao taskDao;

    public Seeder(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        this.seedTasks();
    }

    private void seedTasks(){
        Category category = new Category("Study tasks");
        Task task1 = new Task("Angular video bekijken", "Week 1 video bekijken", category);
        Task task2 = new Task("Springboot vidoe bekijken", "Week 2 video bekijken", category);
        this.taskDao.createTask(task1);
        this.taskDao.createTask(task2);

    }


}
