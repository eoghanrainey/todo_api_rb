package example.rabobank.toDo.repository;

import example.rabobank.toDo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public class ToDoRepository {
    @Repository
    public interface TodoItemRepository extends JpaRepository<ToDo, Long> {
        List<ToDo> findByCompleted(boolean completed);
        List<ToDo> findByDeleted(boolean deleted);
        List<ToDo> findByCreatedDate(LocalDate dateCreated);
    }
}
