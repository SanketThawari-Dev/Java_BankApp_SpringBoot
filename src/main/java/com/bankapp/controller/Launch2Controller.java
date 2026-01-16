package com.bankapp.controller;

import java.sql.Connection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.config.ConnectionFactory;
import com.bankapp.dao.AccountDao;
import com.bankapp.entity.Account;

@Controller
public class Launch2Controller {

    Connection con = ConnectionFactory.getCon();

    AccountDao acDao = new AccountDao();

    @PostMapping("/login")
    public String login(HttpServletRequest req) {

        String uid = req.getParameter("uid");
        String upass = req.getParameter("upass");

        String res = acDao.checkUser(con, uid, upass);
        Account account = acDao.readAccount(con, uid);

        HttpSession session = req.getSession();
        req.getSession().removeAttribute("msg");

        if ("exits".equals(res)) {
            session.setAttribute("check", uid);
            session.setAttribute("ac", account);
            return "redirect:/account.jsp";
        } else {
            session.setAttribute("msg", "Invalid Userid or password");
            return "redirect:/login.jsp";
        }
    }
}
