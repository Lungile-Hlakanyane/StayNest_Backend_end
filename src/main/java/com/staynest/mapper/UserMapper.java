package com.staynest.mapper;
import com.staynest.DTO.UserDTO;
import com.staynest.entity.User;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setActive(false);
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}

