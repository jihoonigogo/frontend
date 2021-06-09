package com.teamproject.controller.users;

import com.teamproject.dto.users.UsersJoinRequestDTO;
import com.teamproject.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UsersService usersService;

    @PostMapping("/join")
    public Long save(@RequestBody UsersJoinRequestDTO requestDTO){
        return usersService.save(requestDTO);
    }
}
