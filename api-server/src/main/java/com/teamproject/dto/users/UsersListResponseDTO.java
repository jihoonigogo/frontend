package com.teamproject.dto.users;

import com.teamproject.domain.Users.Users;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UsersListResponseDTO {
    private Long users_sequence;
    private String email;
    private String password;
    private String nickname;
    private int level;

    public UsersListResponseDTO(Users entity){
        this.users_sequence = entity.getUsers_sequence();
        this.email=entity.getEmail();
        this.password=entity.getPassword();
        this.nickname=entity.getNickname();
        this.level=entity.getLevel();
    }
}
