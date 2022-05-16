package sohyun.seminar.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sohyun.seminar.domain.User;
import sohyun.seminar.domain.UserType;
import sohyun.seminar.service.UserService;
import sohyun.seminar.web.dto.UserResponseDto;
import sohyun.seminar.web.dto.UserSaveRequestDto;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @PostMapping("/test/{name}")
    private User save(@PathVariable String name){
        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .name(name)
                .type(UserType.NORMAL)
                .build();
        return userService.save(requestDto);
    }

    @GetMapping("/test/{id}")
    private UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void userNotFoundHandler(IllegalArgumentException e){}
}
