package com.teamproject.controller.users;


import com.teamproject.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor

public class UserController {

    private final UsersService usersService;

    @GetMapping("/usersList")
    public String usersList(Model model){
        model.addAttribute("users", usersService.findAll());
        return "login";
    }

    @GetMapping("/joinus")
    public String joinUs()
    {
        return "joinus";
    }
}
