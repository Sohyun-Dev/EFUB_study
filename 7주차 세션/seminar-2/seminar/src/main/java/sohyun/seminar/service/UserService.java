package sohyun.seminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sohyun.seminar.domain.User;
import sohyun.seminar.domain.UserRepository;
import sohyun.seminar.web.dto.UserResponseDto;
import sohyun.seminar.web.dto.UserSaveRequestDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById(Long id){
        //User entity = userRepository.findById(id).orElseThrow(() -> new
        //        IllegalArgumentException("해당 사용자가 없습니다. id = "+id));
        User entity = userRepository.getById(id);
        return new UserResponseDto(entity);
    }

    public User save(UserSaveRequestDto requestDTO){
        return userRepository.save(requestDTO.toEntity());
    }
}
