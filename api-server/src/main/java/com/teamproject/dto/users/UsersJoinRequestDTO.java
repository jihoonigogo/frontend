package com.teamproject.dto.users;

import com.teamproject.domain.Users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersJoinRequestDTO {

    private String email;
    private String password;
    private String nickname;
    private int level;

    @Builder
    public UsersJoinRequestDTO(String email, String password, String nickname, int level){
        this.email=email;
        this.password=password;
        this.nickname=nickname;
        this.level=level;
    }

    public Users toEntity(){
        return Users.builder().email(email).nickname(nickname).level(level).password(password).build();
    }
}
