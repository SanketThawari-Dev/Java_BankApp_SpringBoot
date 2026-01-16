package com.bankapp.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.config.ConnectionFactory;
import com.bankapp.dao.AccountDao;
import com.bankapp.dao.Transac_his_dao;

@Controller
public class Launch1Controller {

    Connection con = ConnectionFactory.getCon();

    AccountDao acDao = new AccountDao();
    Transac_his_dao tDao = new Transac_his_dao();

    @PostMapping("/signup")
    public String signup(HttpServletRequest req) {

        String uid = req.getParameter("uid");
        String upass = req.getParameter("upass");
        String uphone = req.getParameter("uphone");
        String uemail = req.getParameter("uemail");
        String city = req.getParameter("city");
        String acholname = req.getParameter("acholname");
        String actype = req.getParameter("actype");
        String atm = req.getParameter("atm");

        tDao.create_table(con, uid);
        String res = acDao.insert(con, uid, upass, uphone, uemail, city, acholname, actype, atm);

        HttpSession session = req.getSession();

        if ("inserted".equals(res)) {
            session.setAttribute("msg", "Account created");
            return "redirect:/login.jsp";
        } else {
            session.setAttribute("msg", "Account Creation Failed");
            return "redirect:/signup.jsp";
        }
    }
}
