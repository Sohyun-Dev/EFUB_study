package sohyun.seminar.web.dto;

import lombok.Getter;
import org.hibernate.usertype.UserType;
import sohyun.seminar.domain.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class UserResponseDto {
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    public UserResponseDto(User entity){
        this.name = entity.getName();
        this.type = entity.getType();
    }
}
