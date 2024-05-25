package EmployeeManagementBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "workschedules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleID;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column
    private LocalDate date;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_time")
    private Time endTime;
    @Column()
    private String notes;
}
