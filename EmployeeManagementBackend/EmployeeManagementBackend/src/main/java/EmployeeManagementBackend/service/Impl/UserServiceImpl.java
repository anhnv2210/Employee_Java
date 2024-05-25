package EmployeeManagementBackend.service.Impl;

import EmployeeManagementBackend.dto.LoginDTO;
import EmployeeManagementBackend.dto.UserDTO;
import EmployeeManagementBackend.dto.UserRegisterDTO;
import EmployeeManagementBackend.entity.Department;
import EmployeeManagementBackend.entity.Employee;
import EmployeeManagementBackend.entity.User;
import EmployeeManagementBackend.mapper.UserMapper;
import EmployeeManagementBackend.repository.DepartmentRepository;
import EmployeeManagementBackend.repository.EmployeeRepository;
import EmployeeManagementBackend.repository.UserRepository;
import EmployeeManagementBackend.response.LoginResponse;
import EmployeeManagementBackend.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public void addUser(UserRegisterDTO userRegisterDTO) {
        if (userRepository.existsByUserName(userRegisterDTO.getUsername())) {
            throw new IllegalArgumentException("Username đã tồn tại");
        }

        Employee employee = new Employee();
        employee.setFirstName(userRegisterDTO.getFirstName());
        employee.setLastName(userRegisterDTO.getLastName());
        employee.setGender(userRegisterDTO.getGender());
        employee.setDateOfBirth(userRegisterDTO.getDateOfBirth());
        employee.setPhone(userRegisterDTO.getPhone());
        employee.setEmail(userRegisterDTO.getEmail());
        employee.setAddress(userRegisterDTO.getAddress());
        employee.setPosition(userRegisterDTO.getPosition());
        employee.setDepartment(departmentRepository.findById(userRegisterDTO.getDepartmentId()).get());
        employee.setHireDate(userRegisterDTO.getHireDate());

        employeeRepository.save(employee);


        User user = new User();
        user.setUserName(userRegisterDTO.getUsername());
        user.setPassword(this.passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setEmployee(employee);
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user -> UserMapper.mapToUserDTO(user))).collect(Collectors.toList());
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User userOptional = userRepository.findByUserName(loginDTO.getUsername());
        if(userOptional != null){
            String pass = loginDTO.getPassword();
            String encodedPassword = userOptional.getPassword();
            Boolean isPwRight = passwordEncoder.matches(pass,encodedPassword);
            if(isPwRight){
                Optional<User> user = userRepository.findOneByUserNameAndPassword(loginDTO.getUsername(),encodedPassword);
                if(user.isPresent()){
                    return new LoginResponse("Login success!",true);
                }else {
                    return new LoginResponse("Login fail!",false)   ;
                }
            }else {
                return new LoginResponse("password not match!",false);
            }
        }else {
            return new LoginResponse("User not exits!",false);
        }
    }
}
