package ru.gb_spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb_spring.jpa.model.Task;
import ru.gb_spring.jpa.model.TaskStatus;

import java.util.List;

@Repository()
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByTaskStatus(TaskStatus status);


}
