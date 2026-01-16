package com.example.banking.repository;

import com.example.banking.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankingRepository {

    private final JdbcTemplate jdbcTemplate;

    public BankingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> getAllAccounts() {
        String sql = "SELECT * FROM account";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Account acc = new Account();
            acc.setId(rs.getInt("id"));
            acc.setName(rs.getString("name"));
            acc.setBalance(rs.getDouble("balance"));
            return acc;
        });
    }
}
