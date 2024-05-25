package EmployeeManagementBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "salary")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column
    private LocalDate payDate;
    @Column
    private Double basicSalary;
    @Column
    private Double overtimePay;
    @Column
    private Double allowances;
    @Column
    private Double deductions;
    @Column
    private Double netSalary;
    @Column
    private Double tax;
    @Column
    private Double insurance;

}
