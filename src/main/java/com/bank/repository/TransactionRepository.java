package com.bank.repository;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bank.entity.TxnHistory;

@Repository
public class TransactionRepository {

    private final JdbcTemplate jdbcTemplate;

    public TransactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertTxn(String uid, String status, String amount) {
        try {
            String acno = jdbcTemplate.queryForObject(
                    "select acno from account where userid=?",
                    String.class,
                    uid
            );

            String bal = jdbcTemplate.queryForObject(
                    "select bal from account where userid=?",
                    String.class,
                    uid
            );

            jdbcTemplate.update(
                    "insert into " + uid + "txn values(?,?,?,?,?)",
                    acno,
                    amount,
                    status,
                    LocalDateTime.now().toString(),
                    bal
            );
        } catch (Exception e) {
            // intentionally ignored (same behavior)
        }
    }

    public List<TxnHistory> readTxn(String uid) {
        return jdbcTemplate.query(
                "select * from " + uid + "txn",
                (ResultSet rs, int rowNum) -> {
                    TxnHistory t = new TxnHistory();
                    t.setAcno(rs.getString(1));
                    t.setAmount(rs.getString(2));
                    t.setTstatus(rs.getString(3));
                    t.setDate(rs.getString(4));
                    t.setBal(rs.getString(5));
                    return t;
                }
        );
    }
}

