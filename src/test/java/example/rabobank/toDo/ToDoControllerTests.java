package example.rabobank.toDo;

import example.rabobank.toDo.controller.ToDoController;
import example.rabobank.toDo.entity.ToDo;
import example.rabobank.toDo.service.ToDoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ToDoControllerTests {

    private ToDoController toDoController;

    @Mock
    private ToDoService toDoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        toDoController = new ToDoController(toDoService);
    }

    @Test
    public void testGetAll() {
        // Arrange
        ToDo toDo1 = new ToDo();
        ToDo toDo2 = new ToDo();
        List<ToDo> toDoList = Arrays.asList(toDo1, toDo2);

        when(toDoService.getAll()).thenReturn(toDoList);

        // Act
        ResponseEntity<List<ToDo>> response = toDoController.getAll();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(toDoList, response.getBody());
    }

    @Test
    public void testCreate() {
        // Arrange
        ToDo toDo = new ToDo();

        when(toDoService.create(toDo)).thenReturn(toDo);

        // Act
        ResponseEntity<ToDo> response = toDoController.create(toDo);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(toDo, response.getBody());
    }

    @Test
    public void testGetCompleted() {
        // Arrange
        ToDo toDo1 = new ToDo();
        ToDo toDo2 = new ToDo();
        List<ToDo> toDoList = Arrays.asList(toDo1, toDo2);

        when(toDoService.getByCompleted()).thenReturn(toDoList);

        // Act
        ResponseEntity<List<ToDo>> response = toDoController.getCompleted();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(toDoList, response.getBody());
    }

    @Test
    public void testGetDeleted() {
        // Arrange
        ToDo toDo1 = new ToDo();
        ToDo toDo2 = new ToDo();
        List<ToDo> toDoList = Arrays.asList(toDo1, toDo2);

        when(toDoService.getByDeleted()).thenReturn(toDoList);

        // Act
        ResponseEntity<List<ToDo>> response = toDoController.getDeleted();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(toDoList, response.getBody());
    }

    @Test
    public void testGetById() {
        // Arrange
        long id = 1L;
        ToDo toDo = new ToDo();

        when(toDoService.getById(id)).thenReturn(toDo);

        // Act
        ResponseEntity<ToDo> response = toDoController.getById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(toDo, response.getBody());
    }

    @Test
    public void testUpdate() {
        // Arrange
        long id = 1L;
        ToDo toDo = new ToDo();
        ToDo updatedToDo = new ToDo();

        when(toDoService.update(id, toDo)).thenReturn(updatedToDo);

        // Act
        ResponseEntity<ToDo> response = toDoController.update(id, toDo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedToDo, response.getBody());
    }

    @Test
    public void testDelete() {
        // Arrange
        long id = 1L;

        // Act
        ResponseEntity<Void> response = toDoController.delete(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(toDoService, times(1)).delete(id);
    }
}

