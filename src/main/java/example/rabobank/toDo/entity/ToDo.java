package example.rabobank.toDo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data

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
        if (newTodo.getDescription() != null) {
            this.description = newTodo.getDescription();
        }
        if (newTodo.getCompleted() != null) {
            this.completed = newTodo.getCompleted();
        }
        if (newTodo.getDeleted() != null) {
            this.deleted = newTodo.getDeleted();
        }
        if (newTodo.getDateToComplete() != null) {
            this.dateToComplete = newTodo.getDateToComplete();
        }
    }
}