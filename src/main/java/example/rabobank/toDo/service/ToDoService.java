package example.rabobank.toDo.service;

import example.rabobank.toDo.entity.ToDo;

import java.util.List;

public interface ToDoService {

        ToDo createToDoEntry(String description);
        ToDo updateToDoEntry(Long id, String description, boolean completed, boolean deleted);
        ToDo markToDoEntryAsCompleted(Long id);
        ToDo markToDoEntryAsDeleted(Long id);
        void deleteToDoEntry(Long id);
        List<ToDo> getAllToDoEntries();
        List<ToDo> getCompletedToDoEntries();
        List<ToDo> getDeletedToDoEntries();
        List<ToDo> getToDoEntriesByCreatedDate();
        List<ToDo> getToDoEntriesByToCompleteByDate();

    }

