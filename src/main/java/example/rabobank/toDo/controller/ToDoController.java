package example.rabobank.toDo.controller;

import example.rabobank.toDo.entity.ToDo;
import example.rabobank.toDo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }
    @GetMapping
    public ResponseEntity<List<ToDo>> getAll() {
        return ResponseEntity.ok(toDoService.getAll());
    }

    @PostMapping
    public ResponseEntity<ToDo> create(@RequestBody ToDo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.create(todo));
    }
    @GetMapping("/completed")
    public ResponseEntity<List<ToDo>> getCompleted() {
        return ResponseEntity.ok(toDoService.getByCompleted());
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<ToDo>> getDeleted() {
        return ResponseEntity.ok(toDoService.getByDeleted());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(toDoService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@PathVariable Long id, @RequestBody ToDo todo) {
        return ResponseEntity.ok(toDoService.update(id, todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        toDoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}