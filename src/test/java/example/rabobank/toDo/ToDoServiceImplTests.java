package example.rabobank.toDo;

import example.rabobank.toDo.entity.ToDo;
import example.rabobank.toDo.repository.ToDoRepository;
import example.rabobank.toDo.service.ToDoService;
import example.rabobank.toDo.service.ToDoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ToDoServiceImplTests {

    @Mock
    private ToDoRepository toDoRepository;

    private ToDoService toDoService;

    private ToDo todo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        toDoService = new ToDoServiceImpl(toDoRepository);
        todo = ToDo.builder()
                .id(1L)
                .description("Test ToDo")
                .completed(false)
                .deleted(false)
                .dateCreated(LocalDate.now())
                .build();
    }

    @Test
    void create() {
        when(toDoRepository.save(any(ToDo.class))).thenReturn(todo);
        ToDo createdToDo = toDoService.create(todo);
        assertNotNull(createdToDo);
        assertEquals(todo.getDescription(), createdToDo.getDescription());
        assertFalse(createdToDo.getCompleted());
        assertFalse(createdToDo.getDeleted());
        assertNotNull(createdToDo.getDateCreated());
        verify(toDoRepository, times(1)).save(any(ToDo.class));
    }
}