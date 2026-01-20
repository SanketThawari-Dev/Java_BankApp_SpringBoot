package com.bankapp.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Launch8Controller {

    @GetMapping("/loginu")
    public String loginu(HttpServletRequest req) {

        req.getSession().removeAttribute("msg");

        // ✅ redirect to controller, not JSP
        return "redirect:/login";
    }
}
