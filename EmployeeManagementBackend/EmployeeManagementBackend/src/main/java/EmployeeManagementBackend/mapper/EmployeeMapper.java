package EmployeeManagementBackend.mapper;

import EmployeeManagementBackend.dto.EmployeeDTO;
import EmployeeManagementBackend.entity.Department;
import EmployeeManagementBackend.entity.Employee;
import EmployeeManagementBackend.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeMapper {
    private static DepartmentRepository departmentRepository;
    public static EmployeeDTO mapToEmployeeDto(Employee employee){
        return new EmployeeDTO(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getDateOfBirth(),
                employee.getPhone(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getPosition(),
                employee.getDepartment().getDepartmentId(),
                employee.getHireDate()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDto){
        Department dept = departmentRepository.findById(employeeDto.getDepartmentId()).get();
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getGender(),
                employeeDto.getDateOfBirth(),
                employeeDto.getPhone(),
                employeeDto.getEmail(),
                employeeDto.getAddress(),
                employeeDto.getPosition(),
                employeeDto.getHireDate(),
                dept

        );
    }
}
