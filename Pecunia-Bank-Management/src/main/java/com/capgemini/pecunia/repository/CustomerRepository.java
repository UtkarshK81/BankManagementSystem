package com.capgemini.pecunia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
