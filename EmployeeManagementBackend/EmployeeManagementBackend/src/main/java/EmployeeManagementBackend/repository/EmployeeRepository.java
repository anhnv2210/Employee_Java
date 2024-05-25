package EmployeeManagementBackend.repository;

import EmployeeManagementBackend.entity.Employee;
import EmployeeManagementBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
