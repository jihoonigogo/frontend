package com.teamproject.domain.freeboard;

import com.teamproject.domain.Users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class FreeBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long free_board_sequence;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "users_sequence")
    private Users users;

    private Date register_date;

    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private int hit;

    private String category;

    @Column(nullable=true)
    private String file;

    private int good;
    private int bad;

}
