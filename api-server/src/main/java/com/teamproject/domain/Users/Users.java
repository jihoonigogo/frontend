package com.teamproject.domain.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long users_sequence;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private int level;

    @Builder
    public Users(String email, String password, String nickname, int level){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.level = level;
    }

}
