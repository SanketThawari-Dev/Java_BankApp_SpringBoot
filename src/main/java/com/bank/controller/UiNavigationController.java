package com.bank.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiNavigationController {

    // Launch8.java
    @GetMapping("/loginu")
    public String loginu(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/login.jsp";
    }

    // Launch9.java
    @GetMapping("/signupu")
    public String signupu(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/signup.jsp";
    }

    // Launch10.java
    @GetMapping("/accountu")
    public String accountu(HttpSession session) {
        session.removeAttribute("msg");
        return "redirect:/account.jsp";
    }
}
