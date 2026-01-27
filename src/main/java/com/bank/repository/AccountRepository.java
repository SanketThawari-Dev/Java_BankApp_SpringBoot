package com.bank.repository;

import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bank.entity.Account;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ===== Launch1 (signup) =====
    public String insert(String id,
                         String upass,
                         String contact,
                         String email,
                         String city,
                         String acholname,
                         String actype,
                         String atm) {
        try {
            int i = jdbcTemplate.update(
                "insert into account values(?,?,?,?,?,?,?,?,?,?)",
                id,
                upass,
                contact,
                email,
                city,
                acholname,
                actype,
                atm,
                contact + "OBS",
                "0"
            );
            return i == 1 ? "inserted" : "failed";
        } catch (Exception e) {
            return "failed";
        }
    }

    // ===== Launch2 (login) =====
    public String checkUser(String id, String upass) {
        try {
            return jdbcTemplate.query(
                "select * from account",
                (ResultSet rs) -> {
                    while (rs.next()) {
                        if (rs.getString(1).equals(id)
                                && rs.getString(2).equals(upass)) {
                            return "exits";
                        }
                    }
                    return "not exits";
                }
            );
        } catch (Exception e) {
            return "not exits";
        }
    }

    // ===== Common =====
    public Account readAccount(String id) {
        return jdbcTemplate.queryForObject(
            "select * from account where userid=?",
            (ResultSet rs, int rowNum) -> {
                Account ac = new Account();
                ac.setUserid(rs.getString(1));
                ac.setPass(rs.getString(2));
                ac.setContact(rs.getString(3));
                ac.setEmail(rs.getString(4));
                ac.setCity(rs.getString(5));
                ac.setAcholname(rs.getString(6));
                ac.setActype(rs.getString(7));
                ac.setAtm(rs.getString(8));
                ac.setAcno(rs.getString(9));
                ac.setBal(rs.getString(10));
                return ac;
            },
            id
        );
    }

    // ===== Launch4 =====
    public String deposit(String id, String am) {
        try {
            String bal = jdbcTemplate.queryForObject(
                "select bal from account where userid=?",
                String.class,
                id
            );

            int updatedBal =
                Integer.parseInt(bal) + Integer.parseInt(am);

            int i = jdbcTemplate.update(
                "update account set bal=? where userid=?",
                String.valueOf(updatedBal),
                id
            );

            return i == 1 ? "updated" : "failed";
        } catch (Exception e) {
            return "failed";
        }
    }

    // ===== Launch5 =====
    public String withdraw(String id, String am) {
        try {
            String bal = jdbcTemplate.queryForObject(
                "select bal from account where userid=?",
                String.class,
                id
            );

            int balance = Integer.parseInt(bal);
            int amt = Integer.parseInt(am);

            if (balance > amt) {
                int i = jdbcTemplate.update(
                    "update account set bal=? where userid=?",
                    String.valueOf(balance - amt),
                    id
                );
                return i == 1 ? "updated" : "failed";
            } else {
                return "failed";
            }
        } catch (Exception e) {
            return "failed";
        }
    }

    // ===== Launch6 =====
    public String transfer(String id, String am, String acb) {
        try {
            String bal = jdbcTemplate.queryForObject(
                "select bal from account where userid=?",
                String.class,
                id
            );

            int balance = Integer.parseInt(bal);
            int amt = Integer.parseInt(am);

            if (balance > amt) {

                // debit sender
                jdbcTemplate.update(
                    "update account set bal=? where userid=?",
                    String.valueOf(balance - amt),
                    id
                );

                // credit receiver
                jdbcTemplate.update(
                    "update account set bal=bal+? where acno=?",
                    amt,
                    acb
                );

                return "updated";
            } else {
                return "failed";
            }
        } catch (Exception e) {
            return "failed";
        }
    }
}

