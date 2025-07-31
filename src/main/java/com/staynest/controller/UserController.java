package com.staynest.controller;
import com.staynest.DTO.*;
import com.staynest.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public String register(@RequestBody UserDTO dto, HttpServletRequest request) {
        String appUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        userService.register(dto, appUrl);
        return "Registration successful. Please check your email to activate your account.";
    }
    @GetMapping("/verify")
    public String verifyToken(@RequestParam String token) {
        return userService.confirmToken(token);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        try {
            LoginResponseDTO response = userService.login(request.getEmail(), request.getPassword());
            System.out.println("LOGIN REQUEST: " + request.getEmail() + ", " + request.getPassword());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponseDTO(e.getMessage(), null, request.getUserId()));
        }
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        UserDTO userDTO = userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO dto) {
        try {
            userService.changePassword(dto.getUserId(), dto.getCurrentPassword(), dto.getNewPassword());
            return ResponseEntity.ok("Password changed successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/update-profile")
    public ResponseEntity<String> updateUserProfile(@RequestBody UpdateUserDTO dto) {
        try {
            userService.updateUserProfile(dto);
            return ResponseEntity.ok("Profile updated successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/users/count")
    public ResponseEntity<Long> getTotalUsersCount() {
        long count = userService.countTotalUsers();
        return ResponseEntity.ok(count);
    }
}
