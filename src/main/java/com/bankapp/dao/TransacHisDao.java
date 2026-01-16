package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.entity.TxnHistory;

public class Transac_his_dao {

    public void create_table(Connection con, String id) {
        try {
            String sql = "create table " + id +
                    "txn(acno varchar(50), amount varchar(50), tStatus varchar(50), date varchar(50), availBal varchar(50))";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertTrans(Connection con, String id, String tStatus, String amount) {
        try {
            String balance = "";
            String acno = "";

            String sql = "select * from account where userid =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                acno = rs.getString("acno");
                balance = rs.getString("bal");
            }

            String sql1 = "insert into " + id + "txn values(?,?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, acno);
            ps1.setString(2, amount);
            ps1.setString(3, tStatus);
            ps1.setString(4, LocalDateTime.now().toString());
            ps1.setString(5, balance);

            ps1.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<TxnHistory> readTxn(Connection con, String uid) {
        List<TxnHistory> al = new ArrayList<>();
        try {
            String sql = "select * from " + uid + "txn";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TxnHistory txn = new TxnHistory();
                txn.setAcno(rs.getString(1));
                txn.setAmount(rs.getString(2));
                txn.setTstatus(rs.getString(3));
                txn.setDate(rs.getString(4));
                txn.setBal(rs.getString(5));

                al.add(txn);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return al;
    }
}
