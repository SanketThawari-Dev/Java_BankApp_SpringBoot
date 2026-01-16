package com.bankapp.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankapp.config.ConnectionFactory;
import com.bankapp.dao.Transac_his_dao;
import com.bankapp.entity.TxnHistory;

@Controller
public class Launch7Controller {

    Connection con = ConnectionFactory.getCon();

    Transac_his_dao txnDao = new Transac_his_dao();

    @GetMapping("/readtxn")
    public String readTxn(HttpServletRequest req) {

        String id = req.getParameter("uid");

        List<TxnHistory> al = txnDao.readTxn(con, id);

        HttpSession session = req.getSession();
        session.setAttribute("check", id);
        session.setAttribute("al", al);

        return "redirect:/readtxn.jsp";
    }
}
