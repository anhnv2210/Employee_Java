package EmployeeManagementBackend.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salary_configurations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalaryConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_configuration_id")
    private Integer salaryConfigurationId;
    @Column(name = "basic_salary_rate")
    private Double basicSalaryRate;
    @Column(name = "overtime_rate")
    private Double overtimeRate;
    @Column(name = "allowance_rate")
    private Double allowanceRate;
    @Column(name = "deduction_rate")
    private Double deductionRate;
    @Column(name = "tax_rate")
    private Double taxRate;
    @Column(name = "insurance_rate")
    private Double insuranceRate;
}
