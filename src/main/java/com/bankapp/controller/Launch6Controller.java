package com.bankapp.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.config.ConnectionFactory;
import com.bankapp.dao.AccountDao;
import com.bankapp.dao.Transac_his_dao;
import com.bankapp.entity.Account;

@Controller
public class Launch6Controller {

    Connection con = ConnectionFactory.getCon();

    AccountDao acDao = new AccountDao();
    Transac_his_dao txnDao = new Transac_his_dao();

    @PostMapping("/transfer")
    public String transfer(HttpServletRequest req) {

        String uid = req.getParameter("uid");
        String am = req.getParameter("am");
        String acb = req.getParameter("acb");

        String res = acDao.mt(con, uid, am, acb);
        txnDao.insertTrans(con, uid, "money transfer", am);

        Account account = acDao.readAccount(con, uid);
        HttpSession session = req.getSession();

        if ("updated".equals(res)) {
            session.setAttribute("check", uid);
            session.setAttribute("ac", account);
            session.setAttribute("msg", "Money Transfered");
            return "redirect:/account.jsp";
        } else {
            session.setAttribute("msg", "Insufficient funds");
            return "redirect:/account.jsp";
        }
    }
}
