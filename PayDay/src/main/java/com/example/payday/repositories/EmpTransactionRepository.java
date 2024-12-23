package com.example.payday.repositories;

import com.example.payday.models.EmpTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpTransactionRepository extends JpaRepository<EmpTransaction, Long> {
    List<EmpTransaction> findBySummary(Double summary);
}
