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
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setGender(dto.getGender());
        user.setActive(dto.getActive() != null ? dto.getActive() : false);
        user.setBlocked(dto.getBlocked() != null ? dto.getBlocked() : false);
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword()); // Be cautious with exposing password
        dto.setRole(user.getRole());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setGender(user.getGender());
        dto.setActive(user.isActive());
        dto.setBlocked(user.isBlocked());
        return dto;
    }
}

