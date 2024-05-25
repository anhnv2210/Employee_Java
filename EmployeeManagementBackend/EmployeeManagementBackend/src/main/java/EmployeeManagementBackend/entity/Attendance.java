package EmployeeManagementBackend.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
@Entity
@Table(name = "attendances")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceID;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column
    private LocalDate date;
    @Column
    private Time checkInTime;
    @Column
    private Time checkOutTime;
    @Column
    private Integer hoursWorked;
    @Column
    private Integer overtimeHours;
}
