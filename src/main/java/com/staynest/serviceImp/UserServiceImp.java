package com.staynest.serviceImp;
import com.staynest.DTO.LoginResponseDTO;
import com.staynest.DTO.UpdateUserDTO;
import com.staynest.DTO.UserDTO;
import com.staynest.entity.User;
import com.staynest.entity.VerificationToken;
import com.staynest.mapper.UserMapper;
import com.staynest.repository.UserRepository;
import com.staynest.repository.VerificationTokenRepository;
import com.staynest.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final VerificationTokenRepository tokenRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Value("${app.frontend-url}")
    private String frontendUrl;
    public UserServiceImp(UserRepository userRepository,
                          VerificationTokenRepository tokenRepository,
                          UserMapper userMapper, PasswordEncoder passwordEncoder,
                          EmailService emailService) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Override
    public void register(UserDTO dto, String appUrl) {
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(
                null,
                token,
                user,
                LocalDateTime.now().plusDays(1)
        );
        tokenRepository.save(verificationToken);
        String link = appUrl + "/api/auth/verify?token=" + token;
        emailService.send(
                user.getEmail(),
                "Account Activation",
                "Click this link to activate your account: " + link
        );
    }

    @Override
    public String confirmToken(String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));
        if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired");
        }
        User user = verificationToken.getUser();
        user.setActive(true);
        userRepository.save(user);
        return "Account activated successfully";
    }
    @Override
    public LoginResponseDTO login(String email, String password) {
        System.out.println("Email received: " + email);
        System.out.println("Password received: " + password);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        System.out.println("DB password hash: " + user.getPassword());

        if (!user.isActive()) {
            throw new RuntimeException("Account is not activated. Please check your email.");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Password did not match.");
            throw new RuntimeException("Invalid email or password");
        }
        return new LoginResponseDTO("Login successful", user.getRole(), user.getId());
    }
    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setGender(user.getGender());
        dto.setPassword(null);
        return dto;
    }
    @Override
    public void changePassword(Long userId, String currentPassword, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new RuntimeException("Current password is incorrect");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
    @Override
    public void updateUserProfile(UpdateUserDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFullName(dto.getFullName());
        user.setPhoneNumber(dto.getPhoneNumber());
        userRepository.save(user);
    }
    @Override
    public long countTotalUsers() {
        return userRepository.count();
    }

}
