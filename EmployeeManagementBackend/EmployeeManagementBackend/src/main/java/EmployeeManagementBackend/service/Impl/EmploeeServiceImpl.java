package EmployeeManagementBackend.service.Impl;

import EmployeeManagementBackend.dto.EmployeeDTO;
import EmployeeManagementBackend.entity.Department;
import EmployeeManagementBackend.entity.Employee;
import EmployeeManagementBackend.mapper.EmployeeMapper;
import EmployeeManagementBackend.repository.DepartmentRepository;
import EmployeeManagementBackend.repository.EmployeeRepository;
import EmployeeManagementBackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmploeeServiceImpl implements EmployeeService {
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setGender(employeeDto.getGender());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setPhone(employeeDto.getPhone());
        employee.setEmail(employeeDto.getEmail());
        employee.setPosition(employeeDto.getPosition());
        employee.setAddress(employeeDto.getAddress());
        employee.setHireDate(employeeDto.getHireDate());
        Department dept = departmentRepository.findById(employeeDto.getDepartmentId()).get();
        employee.setDepartment(dept);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new RuntimeException("Employee is not exist with given id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee))).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new RuntimeException("Employee is not exists with givin id: "+employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setGender(updatedEmployee.getGender());
        employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        employee.setPhone(updatedEmployee.getPhone());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setAddress(updatedEmployee.getAddress());
        employee.setPosition(updatedEmployee.getPosition());
        employee.setHireDate(updatedEmployee.getHireDate());
        Department dept = departmentRepository.findById(updatedEmployee.getDepartmentId()).get();
        employee.setDepartment(dept);

        Employee updateEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployes(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new RuntimeException("Employee is not exists with givin id: "+employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
