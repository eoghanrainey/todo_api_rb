package example.rabobank.toDo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TODO")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean completed;

    @Column(nullable = false)
    private Boolean deleted;

    @Column(nullable = false)
    private LocalDate dateCreated;

    @Column
    private LocalDate dateToComplete;

    public void updateWith(ToDo newTodo) {
        new ToDoBuilder()
                .withId(this.id)
                .withDescription(newTodo.getDescription() != null ? newTodo.getDescription() : this.description)
                .withCompleted(newTodo.getCompleted() != null ? newTodo.getCompleted() : this.completed)
                .withDeleted(newTodo.getDeleted() != null ? newTodo.getDeleted() : this.deleted)
                .withDateCreated(this.dateCreated)
                .withDateToComplete(newTodo.getDateToComplete() != null ? newTodo.getDateToComplete() : this.dateToComplete)
                .build();
    }

    public static class ToDoBuilder {
        private final ToDo todo;

        public ToDoBuilder() {
            todo = new ToDo();
        }

        public ToDoBuilder withId(Long id) {
            todo.setId(id);
            return this;
        }

        public ToDoBuilder withDescription(String description) {
            todo.setDescription(description);
            return this;
        }

        public ToDoBuilder withCompleted(Boolean completed) {
            todo.setCompleted(completed);
            return this;
        }

        public ToDoBuilder withDeleted(Boolean deleted) {
            todo.setDeleted(deleted);
            return this;
        }

        public ToDoBuilder withDateCreated(LocalDate dateCreated) {
            todo.setDateCreated(dateCreated);
            return this;
        }

        public ToDoBuilder withDateToComplete(LocalDate dateToComplete) {
            todo.setDateToComplete(dateToComplete);
            return this;
        }

        public ToDo build() {
            return todo;
        }
    }
}
