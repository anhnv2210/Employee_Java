package EmployeeManagementBackend.mapper;

import EmployeeManagementBackend.dto.UserDTO;
import EmployeeManagementBackend.entity.User;

public class UserMapper {
    public static UserDTO mapToUserDTO(User user){
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getPassword()
        );
    } public static User mapToUser(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getPassword()
        );
    }

}
