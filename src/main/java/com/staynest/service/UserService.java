package com.staynest.service;
import com.staynest.DTO.LoginResponseDTO;
import com.staynest.DTO.UserDTO;

public interface UserService {
    void register(UserDTO dto, String appUrl);
    String confirmToken(String token);
    LoginResponseDTO login(String email, String password);
}
