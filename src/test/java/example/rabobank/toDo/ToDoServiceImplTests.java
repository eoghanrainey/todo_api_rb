package example.rabobank.toDo;

import example.rabobank.toDo.entity.ToDo;
import example.rabobank.toDo.exceptions.ToDoNotFoundException;
import example.rabobank.toDo.repository.ToDoRepository;
import example.rabobank.toDo.service.ToDoService;
import example.rabobank.toDo.service.ToDoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ToDoServiceImplTests {

    private ToDoService toDoService;

    @Mock
    private ToDoRepository toDoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        toDoService = new ToDoServiceImpl(toDoRepository);
    }

    @Test
    public void testGetAll() {
        // Arrange
        ToDo toDo1 = new ToDo();
        ToDo toDo2 = new ToDo();
        List<ToDo> toDoList = Arrays.asList(toDo1, toDo2);

        when(toDoRepository.findAll()).thenReturn(toDoList);

        // Act
        List<ToDo> result = toDoService.getAll();

        // Assert
        assertEquals(toDoList, result);
    }

    @Test
    public void testCreate() {
        // Arrange
        ToDo toDo = new ToDo();
        toDo.setId(1L);
        toDo.setDescription("Test description");
        toDo.setCompleted(false);
        toDo.setDeleted(false);
        toDo.setDateCreated(LocalDate.now());

        when(toDoRepository.save(toDo)).thenReturn(toDo);

        // Act
        ToDo result = toDoService.create(toDo);

        // Assert
        assertEquals(toDo, result);
    }

    @Test
    public void testGetByCompleted() {
        // Arrange
        ToDo toDo1 = new ToDo();
        ToDo toDo2 = new ToDo();
        List<ToDo> toDoList = Arrays.asList(toDo1, toDo2);

        when(toDoRepository.findByCompleted(true)).thenReturn(toDoList);

        // Act
        List<ToDo> result = toDoService.getByCompleted();

        // Assert
        assertEquals(toDoList, result);
    }

    @Test
    public void testGetByDeleted() {
        // Arrange
        ToDo toDo1 = new ToDo();
        ToDo toDo2 = new ToDo();
        List<ToDo> toDoList = Arrays.asList(toDo1, toDo2);

        when(toDoRepository.findByDeleted(true)).thenReturn(toDoList);

        // Act
        List<ToDo> result = toDoService.getByDeleted();

        // Assert
        assertEquals(toDoList, result);
    }

    @Test
    public void testGetById() {
        // Arrange
        long id = 1L;
        ToDo toDo = new ToDo();
        toDo.setId(id);

        when(toDoRepository.findById(id)).thenReturn(Optional.of(toDo));

        // Act
        ToDo result = toDoService.getById(id);

        // Assert
        assertEquals(toDo, result);
    }

    @Test
    public void testGetByIdNotFound() {
        // Arrange
        long id = 1L;

        when(toDoRepository.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ToDoNotFoundException.class, () -> toDoService.getById(id));
    }

    @Test
    public void testDelete() {
        // Arrange
        long id = 1L;

        when(toDoRepository.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ToDoNotFoundException.class, () -> toDoService.delete(id));
    }

}

