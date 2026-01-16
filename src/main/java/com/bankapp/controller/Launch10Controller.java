package com.bankapp.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Launch10Controller {

    @GetMapping("/accountu")
    public String accountu(HttpServletRequest req) {

        req.getSession().removeAttribute("msg");
        return "redirect:/account.jsp";
    }
}
