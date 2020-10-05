package com.capgemini.pecunia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
