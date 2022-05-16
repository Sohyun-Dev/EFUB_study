package sohyun.seminar.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.UserType;
import sohyun.seminar.domain.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Builder
    public UserSaveRequestDto(String name, UserType type){
        this.name = name;
        this.type = type;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .type(type)
                .build();
    }
}
