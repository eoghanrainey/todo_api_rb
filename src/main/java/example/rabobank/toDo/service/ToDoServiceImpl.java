package example.rabobank.toDo.service;

import example.rabobank.toDo.entity.ToDo;
import example.rabobank.toDo.exceptions.ToDoNotFoundException;
import example.rabobank.toDo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new ToDoNotFoundException(id));
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
        existingToDo.updateWith(todo);
        return toDoRepository.save(existingToDo);
    }
    @Override
    public void delete(Long id) {
        if (!toDoRepository.existsById(id)) {
            throw new ToDoNotFoundException(id);
        }
        toDoRepository.deleteById(id);
    }
    @Override
    public List<ToDo> getByCompleted() {
        return toDoRepository.findByCompleted(true);
    }

    @Override
    public List<ToDo> getByDeleted() {
        return toDoRepository.findByDeleted(true);
    }
}
