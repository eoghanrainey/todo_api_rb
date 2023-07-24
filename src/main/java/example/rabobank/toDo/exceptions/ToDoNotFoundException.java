package example.rabobank.toDo.exceptions;

public class ToDoNotFoundException extends RuntimeException {
    public ToDoNotFoundException(Long id) {
        super("ToDo with id " + id + " not found");
    }
}

