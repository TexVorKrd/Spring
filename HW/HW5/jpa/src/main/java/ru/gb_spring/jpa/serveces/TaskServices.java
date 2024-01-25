package ru.gb_spring.jpa.serveces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb_spring.jpa.model.TaskStatus;
import ru.gb_spring.jpa.repositories.TaskRepository;
import ru.gb_spring.jpa.model.Task;

import java.util.List;
import java.util.Optional;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskServices {

    @Autowired
    private TaskRepository repository;

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public List<Task> findAllTask() {
        return repository.findAll();
    }

    public List<Task> findByStatus(TaskStatus status) {
        return repository.findByTaskStatus(status);
    }

    public Task updateStatus(Long id, Task taskDetails) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskStatus(taskDetails.getTaskStatus());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }

    public void deleteTask(Long id) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            repository.delete(task);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }
}
