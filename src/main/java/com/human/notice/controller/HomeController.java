package com.human.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
    public String home(Model model) {
        return "home";  // home.jsp로 이동
    }
}
