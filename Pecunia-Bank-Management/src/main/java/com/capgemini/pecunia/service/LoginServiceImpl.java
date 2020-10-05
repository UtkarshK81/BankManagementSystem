package com.capgemini.pecunia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.entity.Employee;
import com.capgemini.pecunia.exception.LoginError;
import com.capgemini.pecunia.repository.LoginRepository;

@Service

public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginRepository repo;

	@Override
	public Employee saveDetails(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee fetchEmployeeByEmailID(String email) {
		return repo.findByEmpEmail(email);
	}

	@Override
	public Employee fetchEmployeeByEmailIDAndPassword(String email, String password) throws LoginError {
		Employee e = new Employee();
		e = repo.findByEmpEmailAndEmpPassword(email, password);
		if (e == null) {
			throw new LoginError("User Not Found");
		}
		return e;
	}
}