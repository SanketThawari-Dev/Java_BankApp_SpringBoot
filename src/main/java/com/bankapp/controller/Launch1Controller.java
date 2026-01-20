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

@Controller
public class Launch1Controller {

    @Autowired
    private DataSource dataSource;

    AccountDao acDao = new AccountDao();
    Transac_his_dao tDao = new Transac_his_dao();

    @PostMapping("/signup")
    public String signup(HttpServletRequest req) {

        HttpSession session = req.getSession();

        try (Connection con = dataSource.getConnection()) {

            String uid = req.getParameter("uid");
            String upass = req.getParameter("upass");
            String uphone = req.getParameter("uphone");
            String uemail = req.getParameter("uemail");
            String city = req.getParameter("city");
            String acholname = req.getParameter("acholname");
            String actype = req.getParameter("actype");
            String atm = req.getParameter("atm");

            tDao.create_table(con, uid);
            String res = acDao.insert(
                    con, uid, upass, uphone, uemail, city, acholname, actype, atm
            );

            if ("inserted".equals(res)) {
                session.setAttribute("msg", "Account created");

                // ✅ redirect to controller, not JSP
                return "redirect:/login";
            } else {
                session.setAttribute("msg", "Account Creation Failed");
                return "redirect:/signup";
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", "Internal server error");
            return "redirect:/signup";
        }
    }
}
