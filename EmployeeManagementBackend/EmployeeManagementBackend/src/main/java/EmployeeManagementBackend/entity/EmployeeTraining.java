package EmployeeManagementBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "employee_training")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_training_id")
    private Integer employeeTrainingID;
    @Column(name = "completion_status")
    private String completionStatus;
    @Column(name = "completion_date")
    private LocalDate completionDate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;
}
