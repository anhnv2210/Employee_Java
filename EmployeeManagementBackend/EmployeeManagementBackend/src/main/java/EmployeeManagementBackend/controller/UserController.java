package EmployeeManagementBackend.controller;

import EmployeeManagementBackend.dto.LoginDTO;
import EmployeeManagementBackend.dto.UserDTO;
import EmployeeManagementBackend.dto.UserRegisterDTO;
import EmployeeManagementBackend.response.LoginResponse;
import EmployeeManagementBackend.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    // Build Add User REST API
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegisterDTO userRegistrationDTO) {
        try {
            userService.addUser(userRegistrationDTO);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> users= userService.getUsers();
        return  ResponseEntity.ok(users);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);

    }
}
