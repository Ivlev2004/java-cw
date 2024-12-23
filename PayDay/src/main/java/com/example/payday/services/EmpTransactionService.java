package com.example.payday.services;

import com.example.payday.models.EmpTransaction;
import com.example.payday.models.User;
import com.example.payday.repositories.EmpTransactionRepository;
import com.example.payday.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class EmpTransactionService {
    private final EmpTransactionRepository empTransactionRepository;
    private final UserRepository userRepository;

    public EmpTransactionService(EmpTransactionRepository empTransactionRepository, UserRepository userRepository) {
        this.empTransactionRepository = empTransactionRepository;
        this.userRepository = userRepository;
    }

    public List<EmpTransaction> listEmpTransaction(Double summary) {
        if (summary != null) return empTransactionRepository.findBySummary(summary);
        return empTransactionRepository.findAll();
    }

    public void saveEmpTransaction(User recipient, Double summary, User sender) {
        EmpTransaction empTransaction = new EmpTransaction();
        empTransaction.setRecipient(recipient);
        empTransaction.setSender(sender);
        empTransaction.setSummary(summary);
        empTransactionRepository.save(empTransaction);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public EmpTransaction getEmpTransaction(Long id) {
        return empTransactionRepository.findById(id).orElse(null);
    }

    public EmpTransaction getTransactionById(Long empTransactionId) {
        return empTransactionRepository.findById(empTransactionId).orElse(null);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
