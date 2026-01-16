package com.bankapp.controller;

import java.sql.Connection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.config.ConnectionFactory;
import com.bankapp.dao.AccountDao;
import com.bankapp.dao.Transac_his_dao;
import com.bankapp.entity.Account;

@Controller
public class Launch5Controller {

    Connection con = ConnectionFactory.getCon();

    AccountDao acDao = new AccountDao();
    Transac_his_dao txnDao = new Transac_his_dao();

    @PostMapping("/withdraw")
    public String withdraw(HttpServletRequest req) {

        String uid = req.getParameter("uid");
        String am = req.getParameter("am");

        String res = acDao.withdraw(con, uid, am);
        txnDao.insertTrans(con, uid, "withdraw", am);

        Account account = acDao.readAccount(con, uid);
        HttpSession session = req.getSession();

        if ("updated".equals(res)) {
            session.setAttribute("check", uid);
            session.setAttribute("ac", account);
            session.setAttribute("msg", "Money withdraw");
            return "redirect:/account.jsp";
        } else {
            session.setAttribute("msg", "Insufficient funds");
            return "redirect:/account.jsp";
        }
    }
}
