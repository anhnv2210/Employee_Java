package EmployeeManagementBackend.service;

import EmployeeManagementBackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDto);
    EmployeeDTO getEmployeeById(Integer employeeId);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO updatedEmployee);
    void deleteEmployes(Integer employeeId);

}
