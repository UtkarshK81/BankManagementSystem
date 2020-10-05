package com.capgemini.pecunia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Employee;


@Repository

public interface LoginRepository extends JpaRepository<Employee, Long> {
	
	public Employee findByEmpEmail(String email);
	public Employee findByEmpEmailAndEmpPassword(String email,String passsword);
}