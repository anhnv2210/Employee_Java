package EmployeeManagementBackend.entity;

import EmployeeManagementBackend.repository.DepartmentRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String address;
    private String position;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Leave> leaves;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<WorkSchedule> workSchedules;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeTraining> employeeTrainings;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Salary> salaries;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeContract> employeeContracts;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private User user;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(Integer id, String FirstName, String LastName, String Gender, LocalDate DateOfBirth, String Phone, String Email, String Address, String Position, LocalDate HireDate, Department dept) {
        employeeId = id;
        firstName = FirstName;
        lastName = LastName;
        gender = Gender;
        dateOfBirth = DateOfBirth;
        phone = Phone;
        email = Email;
        address =Address;
        position =Position;
        hireDate = HireDate;
        setDepartment(dept);
    }

}
