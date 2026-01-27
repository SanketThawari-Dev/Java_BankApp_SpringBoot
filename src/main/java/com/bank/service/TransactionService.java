package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.entity.TxnHistory;
import com.bank.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // ===== Launch1 =====
    public void createTxnTable(String uid) {
        transactionRepository.createTxnTable(uid);
    }

    // ===== Launch4,5,6 =====
    public void insertTxn(String uid, String status, String amount) {
        transactionRepository.insertTxn(uid, status, amount);
    }

    // ===== Launch7 =====
    public List<TxnHistory> readTxn(String uid) {
        return transactionRepository.readTxn(uid);
    }
}

