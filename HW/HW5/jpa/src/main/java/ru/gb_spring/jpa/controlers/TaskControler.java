package ru.gb_spring.jpa.controlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb_spring.jpa.model.Task;
import ru.gb_spring.jpa.model.TaskStatus;
import ru.gb_spring.jpa.serveces.TaskServices;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping
public class TaskControler {


    @Autowired
    private TaskServices service;

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping("/listTasks")
    public List<Task> getAllTasks() {
        return service.findAllTask();
    }

    @GetMapping("/taskByStatus/{status}")
    public List<Task> getAllTasks(@PathVariable TaskStatus status) {
        return service.findByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateStatus(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }

}
