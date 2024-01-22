package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domain.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    List<String> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
    }

    public void addTask(String task) {
        if (task != null && !task.contains("")) {
            tasks.add(task);
        }
    }

    public List<String> taskList() {
        return tasks;

    }
}
