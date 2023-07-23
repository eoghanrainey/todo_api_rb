package example.rabobank.toDo.service;

import example.rabobank.toDo.entity.ToDo;
import example.rabobank.toDo.repository.ToDoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDo getById(Long id) {
        return toDoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ToDo with id " + id + " not found"));
    }

    @Override
    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo create(ToDo todo) {
        return toDoRepository.save(todo);
    }

    @Override
    public ToDo update(Long id, ToDo todo) {
        ToDo existingToDo = getById(id);

        ToDo updatedToDo = ToDo.builder()
                .id(existingToDo.getId())
                .dateCreated(existingToDo.getDateCreated())
                .description(todo.getDescription())
                .completed(todo.isCompleted())
                .deleted(todo.isDeleted())
                .dateToComplete(todo.getDateToComplete())
                .build();

        return toDoRepository.save(updatedToDo);
    }

    @Override
    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public List<ToDo> getByCreatedDate(LocalDate date) {
        return toDoRepository.findByDateCreated(date);
    }

    @Override
    public List<ToDo> getByCompleted(boolean completed) {
        return toDoRepository.findByCompleted(completed);
    }

    @Override
    public List<ToDo> getByDeleted(boolean deleted) {
        return toDoRepository.findByDeleted(deleted);
    }
}
