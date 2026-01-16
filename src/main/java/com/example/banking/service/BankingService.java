package com.example.banking.service;

import com.example.banking.model.Account;
import com.example.banking.repository.BankingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingService {

    private final BankingRepository repository;

    public BankingService(BankingRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAccounts() {
        return repository.getAllAccounts();
    }
}
