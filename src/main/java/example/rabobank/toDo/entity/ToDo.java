package example.rabobank.toDo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = false)
    private boolean deleted;

    @Column(nullable = false)
    private LocalDate dateCreated;

    @Column
    private LocalDate dateToComplete;

    public ToDo() {
    }


    public ToDo(Long id, String description, boolean completed, boolean deleted, LocalDate dateCreated, LocalDate dateToComplete) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.deleted = deleted;
        this.dateCreated = dateCreated;
        this.dateToComplete = dateToComplete;
    }

    public ToDo(Long id, String description, boolean completed, boolean deleted, LocalDate dateCreated) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.deleted = deleted;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(LocalDate dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
