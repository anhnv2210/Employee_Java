package EmployeeManagementBackend.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "First name không được để trống")
    private Integer id;
    @NotEmpty(message = "First name không được để trống")
    private String firstName;

    @NotEmpty(message = "Last name không được để trống")
    private String lastName;

    @NotEmpty(message = "Gender không được để trống")
    private String gender;

    @NotEmpty(message = "Date of Birth không được để trống")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Phone không được để trống")
    private String phone;

    @NotEmpty(message = "Email không được để trống")
    private String email;

    @NotEmpty(message = "Address không được để trống")
    private String address;

    @NotEmpty(message = "Position không được để trống")
    private String position;

    private int departmentId;

    private LocalDate hireDate;
}
