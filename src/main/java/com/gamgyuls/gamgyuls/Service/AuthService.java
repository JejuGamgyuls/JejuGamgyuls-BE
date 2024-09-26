package com.gamgyuls.gamgyuls.Service;

import com.gamgyuls.gamgyuls.dto.ResponseDto;
import com.gamgyuls.gamgyuls.dto.SignUpDto;
import com.gamgyuls.gamgyuls.entity.UserEntity;
import com.gamgyuls.gamgyuls.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getEmail();
        String userId = dto.getUserId();
        String userPassword = dto.getPwd();
        String userName = dto.getName();

        UserEntity userEntity = new UserEntity(dto);

        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            ResponseDto.setFailed("Database Error");
        }

        return ResponseDto.setSuccess("SignUp Success!", null);
    }

}
