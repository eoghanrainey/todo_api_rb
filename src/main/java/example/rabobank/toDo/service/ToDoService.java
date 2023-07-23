package example.rabobank.toDo.service;

import example.rabobank.toDo.entity.ToDo;

import java.time.LocalDate;
import java.util.List;

public interface ToDoService {

    ToDo create(ToDo todo);

    ToDo update(Long id, ToDo todo);

    void delete(Long id);

    ToDo getById(Long id);

    List<ToDo> getAll();

    List<ToDo> getByCompleted();

    List<ToDo> getByDeleted();

    List<ToDo> getByCreatedDate(LocalDate createdDate);
}



