package com.bank.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.service.AccountService;
import com.bank.service.TransactionService;

@Controller
public class AccountController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public AccountController(AccountService accountService,
                             TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    // Launch4.java
    @PostMapping("/deposit")
    public String deposit(HttpServletRequest req, HttpSession session) {

        String uid = req.getParameter("uid");
        String am = req.getParameter("am");

        String res = accountService.deposit(uid, am);
        transactionService.insertTxn(uid, "deposit", am);

        session.setAttribute("ac", accountService.readAccount(uid));

        session.setAttribute(
                "msg",
                "updated".equals(res) ? "Money deposited" : "Failed"
        );

        return "redirect:/account.jsp";
    }

    // Launch5.java
    @PostMapping("/withdraw")
    public String withdraw(HttpServletRequest req, HttpSession session) {

        String uid = req.getParameter("uid");
        String am = req.getParameter("am");

        String res = accountService.withdraw(uid, am);
        transactionService.insertTxn(uid, "withdraw", am);

        session.setAttribute("ac", accountService.readAccount(uid));

        session.setAttribute(
                "msg",
                "updated".equals(res) ? "Money withdraw" : "Insufficient funds"
        );

        return "redirect:/account.jsp";
    }

    // Launch6.java
    @PostMapping("/transfer")
    public String transfer(HttpServletRequest req, HttpSession session) {

        String uid = req.getParameter("uid");
        String am = req.getParameter("am");
        String acb = req.getParameter("acb");

        String res = accountService.transfer(uid, am, acb);
        transactionService.insertTxn(uid, "money transfer", am);

        session.setAttribute("ac", accountService.readAccount(uid));

        session.setAttribute(
                "msg",
                "updated".equals(res) ? "Money Transfered" : "Insufficient funds"
        );

        return "redirect:/account.jsp";
    }
}
