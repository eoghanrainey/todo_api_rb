package example.rabobank.toDo;

import example.rabobank.toDo.controller.ToDoController;
import example.rabobank.toDo.entity.ToDo;
import example.rabobank.toDo.service.ToDoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ToDoControllerTests {

    @Mock
    private ToDoService toDoService;

    @InjectMocks
    private ToDoController toDoController;

    private ToDo todo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<ToDo> expectedToDos = new ArrayList<>();
        expectedToDos.add(new ToDo(1L, "ToDo 1", false, false, LocalDate.now(), null));
        expectedToDos.add(new ToDo(2L, "ToDo 2", false, false, LocalDate.now(), null));
        when(toDoService.getAll()).thenReturn(expectedToDos);

        ResponseEntity<List<ToDo>> response = toDoController.getAll();
        List<ToDo> actualToDos = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedToDos, actualToDos);
        verify(toDoService, times(1)).getAll();
    }

    @Test
    public void testGetCompleted() {
        List<ToDo> expectedToDos = new ArrayList<>();
        expectedToDos.add(new ToDo(1L, "Completed ToDo 1", true, false, LocalDate.now(), null));
        expectedToDos.add(new ToDo(2L, "Completed ToDo 2", true, false, LocalDate.now(), null));
        when(toDoService.getByCompleted()).thenReturn(expectedToDos);

        ResponseEntity<List<ToDo>> response = toDoController.getCompleted();
        List<ToDo> actualToDos = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedToDos, actualToDos);
        verify(toDoService, times(1)).getByCompleted();
    }

    @Test
    public void testGetDeleted() {
        List<ToDo> expectedToDos = new ArrayList<>();
        expectedToDos.add(new ToDo(1L, "Deleted ToDo 1", false, true, LocalDate.now(), null));
        expectedToDos.add(new ToDo(2L, "Deleted ToDo 2", false, true, LocalDate.now(), null));
        when(toDoService.getByDeleted()).thenReturn(expectedToDos);

        ResponseEntity<List<ToDo>> response = toDoController.getDeleted();
        List<ToDo> actualToDos = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedToDos, actualToDos);
        verify(toDoService, times(1)).getByDeleted();
    }

    @Test
    public void testGetById() {
        Long id = 1L;
        ToDo expectedToDo = new ToDo(id, "ToDo 1", false, false, LocalDate.now(), null);
        when(toDoService.getById(id)).thenReturn(expectedToDo);

        ResponseEntity<ToDo> response = toDoController.getById(id);
        ToDo actualToDo = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedToDo, actualToDo);
        verify(toDoService, times(1)).getById(id);
    }


    @Test
    public void testUpdate() {
        Long id = 1L;
        ToDo updatedToDo = new ToDo(id, "Updated ToDo", true, false, LocalDate.now(), null);
        when(toDoService.update(eq(id), any(ToDo.class))).thenReturn(updatedToDo);

        ResponseEntity<ToDo> response = toDoController.update(id, updatedToDo);
        ToDo actualToDo = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedToDo, actualToDo);
        verify(toDoService, times(1)).update(eq(id), any(ToDo.class));
    }

    @Test
    public void testDelete() {
        Long id = 1L;

        ResponseEntity<Void> response = toDoController.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(toDoService, times(1)).delete(id);
    }
}