package com.bank.service;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bank.entity.Account;
import com.bank.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // ===== Launch1 (signup) =====
    public String insert(HttpServletRequest req) {
        return accountRepository.insert(
                req.getParameter("uid"),
                req.getParameter("upass"),
                req.getParameter("uphone"),
                req.getParameter("uemail"),
                req.getParameter("city"),
                req.getParameter("acholname"),
                req.getParameter("actype"),
                req.getParameter("atm")
        );
    }

    // ===== Launch2 (login) =====
    public String checkUser(String uid, String upass) {
        return accountRepository.checkUser(uid, upass);
    }

    // ===== Common =====
    public Account readAccount(String uid) {
        return accountRepository.readAccount(uid);
    }

    // ===== Launch4 =====
    public String deposit(String uid, String am) {
        return accountRepository.deposit(uid, am);
    }

    // ===== Launch5 =====
    public String withdraw(String uid, String am) {
        return accountRepository.withdraw(uid, am);
    }

    // ===== Launch6 =====
    public String transfer(String uid, String am, String acb) {
        return accountRepository.transfer(uid, am, acb);
    }
}

