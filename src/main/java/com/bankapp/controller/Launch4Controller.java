package com.bankapp.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.dao.AccountDao;
import com.bankapp.dao.Transac_his_dao;
import com.bankapp.entity.Account;

@Controller
public class Launch4Controller {

    @Autowired
    private DataSource dataSource;

    AccountDao acDao = new AccountDao();
    Transac_his_dao txnDao = new Transac_his_dao();

    @PostMapping("/deposit")
    public String deposit(HttpServletRequest req) {

        HttpSession session = req.getSession();

        try (Connection con = dataSource.getConnection()) {

            String uid = req.getParameter("uid");
            String am = req.getParameter("am");

            String res = acDao.deposit(con, uid, am);
            txnDao.insertTrans(con, uid, "deposit", am);

            Account account = acDao.readAccount(con, uid);

            if ("updated".equals(res)) {
                session.setAttribute("check", uid);
                session.setAttribute("ac", account);
                session.setAttribute("msg", "Money deposited");
                return "redirect:/account.jsp";
            } else {
                session.setAttribute("msg", "Failed");
                return "redirect:/account.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", "Internal server error");
            return "redirect:/account.jsp";
        }
    }
}
