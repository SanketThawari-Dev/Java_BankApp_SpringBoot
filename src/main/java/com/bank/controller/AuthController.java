package com.bank.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.service.AccountService;
import com.bank.service.TransactionService;

@Controller
public class AuthController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public AuthController(AccountService accountService,
                          TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @GetMapping("/loginu")
public String loginPage() {
    return "login";   // renders login.jsp
}

@PostMapping("/login")
public String login(HttpServletRequest request, HttpSession session) {

    String uid = request.getParameter("uid");
    String upass = request.getParameter("upass");

    if ("exists".equals(accountService.checkUser(uid, upass))) {
        session.setAttribute("check", uid);
        session.setAttribute("ac", accountService.readAccount(uid));
        return "redirect:/accountu";
    }

    request.setAttribute("msg", "Invalid Credentials");
    return "login";   // forward, NOT redirect
}


    // 👉 Logout (MUST NOT be /login)
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginu";
    }
}
