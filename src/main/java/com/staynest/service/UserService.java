package com.staynest.service;
import com.staynest.DTO.LoginResponseDTO;
import com.staynest.DTO.UpdateUserDTO;
import com.staynest.DTO.UserDTO;

import java.util.List;

public interface UserService {
    void register(UserDTO dto, String appUrl);
    String confirmToken(String token);
    LoginResponseDTO login(String email, String password);
    UserDTO getUserById(Long userId);
    void changePassword(Long userId, String currentPassword, String newPassword);
    void updateUserProfile(UpdateUserDTO dto);
    long countTotalUsers();
    List<UserDTO> getAllUsers();
    void deleteUserById(Long userId);
    void setUserBlocked(Long userId, boolean blocked);
}
