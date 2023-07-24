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
    private boolean completed;

    @Column(nullable = false)
    private boolean deleted;

    @Column(nullable = false)
    private LocalDate dateCreated;

    @Column
    private LocalDate dateToComplete;


}
