package EmployeeManagementBackend.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {
    @NotEmpty(message = "Username không được để trống")
    private String username;

    @NotEmpty(message = "Password không được để trống")
    @Size(min = 6, message = "Password phải có ít nhất 6 ký tự")
    private String password;

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
