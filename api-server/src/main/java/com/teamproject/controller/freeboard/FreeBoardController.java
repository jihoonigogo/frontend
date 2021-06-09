package com.teamproject.controller.freeboard;

import com.teamproject.service.freeboard.FreeBoardService;
import com.teamproject.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor

public class FreeBoardController {

    private final FreeBoardService freeBoardService;

    @GetMapping("/freeboard")
    public String freeboard(Model model){
        model.addAttribute("freeboards", freeBoardService.findAll());
        return "freeboard";
    }

}
