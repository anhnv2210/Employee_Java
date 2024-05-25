package EmployeeManagementBackend.service;

import EmployeeManagementBackend.dto.LoginDTO;
import EmployeeManagementBackend.dto.UserDTO;
import EmployeeManagementBackend.dto.UserRegisterDTO;
import EmployeeManagementBackend.response.LoginResponse;

import java.util.List;

public interface UserService {
    void addUser(UserRegisterDTO userRegisterDTO);
    List<UserDTO> getUsers();
    LoginResponse loginUser(LoginDTO loginDTO);
}
