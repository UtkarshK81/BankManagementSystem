package com.capgemini.pecunia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}
