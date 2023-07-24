package example.rabobank.toDo.repository;

import example.rabobank.toDo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByCompleted(boolean completed);

    List<ToDo> findByDeleted(boolean deleted);

}

