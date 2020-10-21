package io.github.jack92w.todoapp.controller;

import io.github.jack92w.todoapp.model.Task;
import io.github.jack92w.todoapp.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {
    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    public final TaskRepository repository;
    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
        //adnotcja sprawia, ze informacje sa wyswietlane w uproszczony sposob
        //params = "sort, wchodzimy w ten controller tylko wtedy gdy nie ma parametrów sort, page, size.
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

   @PutMapping("/tasks/{id}") //metoda html PUT
    ResponseEntity<?> updateTask(@RequestBody @Valid Task toUpdate){
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

}
