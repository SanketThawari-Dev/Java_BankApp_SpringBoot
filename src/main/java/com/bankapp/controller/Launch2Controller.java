package com.bankapp.controller;

import javax.sql.DataSource;
import java.sql.Connection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.dao.AccountDao;
import com.bankapp.entity.Account;

@Controller
public class Launch2Controller {

    @Autowired
    private DataSource dataSource;

    AccountDao acDao = new AccountDao();

    @PostMapping("/login")
    public String login(HttpServletRequest req) {

        try (Connection con = dataSource.getConnection()) {

            String uid = req.getParameter("uid");
            String upass = req.getParameter("upass");

            String res = acDao.checkUser(con, uid, upass);
            Account account = acDao.readAccount(con, uid);

            HttpSession session = req.getSession();
            session.removeAttribute("msg");

            if ("exits".equals(res)) {
                session.setAttribute("check", uid);
                session.setAttribute("ac", account);

                // ✅ redirect to controller, NOT JSP
                return "redirect:/account";
            } else {
                session.setAttribute("msg", "Invalid Userid or password");
                return "redirect:/login";
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("msg", "Internal server error");
            return "redirect:/login";
        }
    }
}
