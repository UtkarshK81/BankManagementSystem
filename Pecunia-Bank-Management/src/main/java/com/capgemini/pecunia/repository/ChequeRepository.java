package com.capgemini.pecunia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Cheque;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque,Long>{

}
