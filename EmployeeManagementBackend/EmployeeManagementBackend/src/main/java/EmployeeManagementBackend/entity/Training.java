package EmployeeManagementBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trainings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private int trainingId;
    @Column(name = "training_name")
    private String trainingName;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<EmployeeTraining> employeeTrainings;
}
